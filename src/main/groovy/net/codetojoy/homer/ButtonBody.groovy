
package net.codetojoy.homer

class ButtonBody {    
    String build(def linksList) {
        def buffer = new StringBuilder()
        
        linksList.each { links ->
            def header = links.header
            buffer.append("<h3><a href='#'>${header}</a></h3>" + "\n")
            
            links.links.each { link ->
                def href = link.href
                def name = link.name
                buffer.append("<a class='link' href='${href}'>${name}</a>" + "\n")
            }

            buffer.append("<br/>" + "\n")
        }
        
        return buffer.toString()
    }
}
