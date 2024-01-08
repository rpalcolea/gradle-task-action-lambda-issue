package task.action.issue

import nebula.test.IntegrationTestKitSpec

class PluginTest extends IntegrationTestKitSpec {
    def setup() {
        definePluginOutsideOfPluginBlock = true
    }

    def 'test'() {
        when:
        buildFile << """
           apply plugin: "task.action.issue.greeting"
           apply plugin: "java-library"          
"""
        writeHelloWorld()

        then:
        runTasks('jar', '--warning-mode', 'all', '--scan')
    }
}
