package by.efreet.gradle;

import org.gradle.api.Plugin
import org.gradle.api.Project

public class MyAWSPluginV1 implements Plugin<Project> {
    
    public MyAWSPluginV1() {
        println "MyAWSPluginV1 ctor"
    }
    
    public void apply(Project p) {
        println "MyAWSPluginV1 apply"
        def copyToS3 = p.task("copyToS3V1") {
            description = "copyToS3V1"
            group = "deploy"
            doLast {
                println "Copied to S3 (v1)"
            }
        }
        def deployToEC2 = p.task("deployToEC2V1") {
            description = "deployToEC2V1"
            group = "deploy"
            doLast {
                println "App is up and running on AWS EC2 (v1)"
            }
        }
        // deployToEC2.dependsOn(copyToS3)
    }
}