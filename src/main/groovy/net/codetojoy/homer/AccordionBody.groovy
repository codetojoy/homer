
package net.codetojoy.homer

class AccordionBody {    
    String build(def linksList) {
        def buffer = new StringBuilder()
        
        linksList.each { links ->
            def header = links.header
            buffer.append("<h3><a href='#'>${header}</a></h3>" + "\n")
            buffer.append("<div>" + "\n")
            
            links.links.each { link ->
                def href = link.href
                def name = link.name
                buffer.append("<a class='link' href='${href}'>${name}</a> <br/>" + "\n")
            }
            
            buffer.append("</div>" + "\n")
        }
        
        return buffer.toString()
    }
}
