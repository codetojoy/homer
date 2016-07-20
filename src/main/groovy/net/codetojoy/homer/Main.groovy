
package net.codetojoy.homer

def run = { def inputFile, def configFile, def bodyStyle ->
    def config = new Config(configFile)

    def model = new Model(config)
    model.build(new File(inputFile))

    def template = new Template(bodyStyle)
    def output = template.stamp(model)

    new File("home.html").withWriter { it.write(output) }
}

def usage = { ->
    println.err "Usage: java -jar Homer.jar linksFile configFile [accordion|button]"
}

// --------- MAIN

if (args.size() >= 3) {
    run(args[0], args[1], args[2])
} else {
    usage()
}

println "done."        

