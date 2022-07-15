package ckanywhere.awslambdademo

import com.amazonaws.serverless.exceptions.ContainerInitializationException
import com.amazonaws.serverless.proxy.model.AwsProxyRequest
import com.amazonaws.serverless.proxy.model.AwsProxyResponse
import com.amazonaws.serverless.proxy.spring.SpringBootLambdaContainerHandler
import com.amazonaws.services.lambda.runtime.Context
import com.amazonaws.services.lambda.runtime.RequestStreamHandler

import java.io.InputStream
import java.io.OutputStream

class StreamLambdaHandler: RequestStreamHandler {
    companion object {
        var handler: SpringBootLambdaContainerHandler<AwsProxyRequest, AwsProxyResponse>

        init {
            try {
                handler = SpringBootLambdaContainerHandler.getAwsProxyHandler(AwsLambdaDemoApplication::class.java)
            } catch (e: ContainerInitializationException) {
                e.printStackTrace()
                throw RuntimeException("Could not initialize Spring Boot application", e)
            }
        }
    }

    override fun handleRequest(inputStream: InputStream, outputStream: OutputStream, context: Context) {
        handler.proxyStream(inputStream, outputStream, context)
    }
}