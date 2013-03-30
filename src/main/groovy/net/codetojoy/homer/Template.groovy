
package net.codetojoy.homer

class Template {
    final static String HEADER = """
<html>
<head>
    <script type="text/javascript" src="%s"></script>
    <script type="text/javascript" src="%s"></script>
    <link rel="stylesheet" href="%s"></link>

    <script>
        \$(function() {
            \$( "#accordion" ).accordion({ autoHeight : false, clearStyle : true});
            \$( ".link" ).button();
        });
    </script>
</head>
<body>
<div id="accordion">"""

    final static String FOOTER = "</div></body></html>"
    
    public String stamp(Model model) {
        String mainHeader = String.format(HEADER, model.jQueryPath,
                                            model.jQueryUiPath,
                                            model.jQueryUiCssPath)

        def buffer = new StringBuilder(mainHeader + "\n")
        
        model.linksList.each { links ->
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
        
        buffer.append(FOOTER)
        return buffer.toString()
    }
}
