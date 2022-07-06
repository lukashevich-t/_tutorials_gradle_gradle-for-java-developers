package by.efreet.gradle;

import org.gradle.api.Plugin
import org.gradle.api.Project

public class MyAWSPluginV2 implements Plugin<Project> {
    
    public MyAWSPluginV2() {
        println "MyAWSPluginV2 ctor"
    }
    
    public void apply(Project p) {
        println "MyAWSPluginV2 apply"
        def copyToS3 = p.task("copyToS3V2") {
            description = "copyToS3V2"
            group = "deploy"
            doLast {
                println "Copied to S3 (v2)"
            }
        }
        def deployToEC2 = p.task("deployToEC2V2") {
            description = "deployToEC2V2"
            group = "deploy"
            doLast {
                println "App is up and running on AWS EC2 (v2)"
            }
        }
        deployToEC2.dependsOn(copyToS3)
    }
}