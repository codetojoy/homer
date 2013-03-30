
package net.codetojoy.homer

class Model {    
    def jQueryPath
    def jQueryUiPath
    def jQueryUiCssPath
    
    def linksList = []
    def currentLinks = null
    
    public Model(def config) {
        this.jQueryPath = config.jQueryPath
        this.jQueryUiPath = config.jQueryUiPath
        this.jQueryUiCssPath = config.jQueryUiCssPath
    }
    
    public void build(File file) {
        file.eachLine { line ->
            processLine(line)
        }
    }

    // for debugging
    public void emitLog() {
        linksList.each { links ->
            println links.header
            links.links.each { link ->
                println link.name + " , " + link.href
            }
        }
    }
    
    // ---------- internal 
    
    protected def processHeader(def header) {
        currentLinks = new Links()
        currentLinks.header = header
        linksList << currentLinks
    }
    
    protected def processLink(def name, def href) {
        def link = new Link()
        link.name = name.trim()
        link.href = href.trim()
        currentLinks.links << link
    }
    
    protected def processLine(def line) {
        if (! line.trim().isEmpty()) {
            def fields = line.split(",")
            
            if (fields.size() == 1) {
                processHeader(fields[0])
            } else {
                processLink(fields[0], fields[1])
            }
        }
    }
    
}