
package net.codetojoy.homer

class Main {
    def run(inputFile, configFile, bodyStyle) {
        def config = new Config(configFile)

        def model = new Model(config)
        model.build(new File(inputFile))

        def template = new Template(bodyStyle)
        def output = template.stamp(model)

        new File("home.html").withWriter { it.write(output) }
    }

    def usage() {
        System.err.println "Usage: ./bin/homer linksFile configFile [accordion|button]"
    }

    static void main(String[] args) {
        def main = new Main()

        if (args.size() >= 3) {
            try {
                main.run(args[0], args[1], args[2])
            } catch (Exception ex) {
                System.err.println "caught exception: " + ex.message
            }
        } else {
            main.usage()
        }

        println "Ready."
    }
}

/*


// --------- MAIN

println "done."        
*/
