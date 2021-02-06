<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet 
    xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xmlns:xs="http://www.w3.org/2001/XMLSchema" 
    version="2.0">
    
    <xsl:template match="/">
        <html>
            <head>
                <style>
                    html, body {
                    height: 100%;
                    }
                    
                    html {
                    display: table;
                    margin-left: 10%;
                    margin-right: 10%;
                    margin-top: 8%;
                    margin-bottom: 8%;
                    }
                    
                    body {
                    display: table-cell;
                    vertical-align: middle;
                    align-content: center;
                    }
                    
                    .indented {
                    text-indent: 30px;
                    }
                    
                    .add-space-after {
                    margin-bottom: 50px;
                    }
                    
                    .half{
                    width: 40%;
                    }
                    
                    table, th, td {
                    border: 1px solid black;
                    border-collapse: collapse;
                    }
                </style>
            </head>
            
            <body>
                
                
                <h1 class="add-space-after"> <u> Godisnji izvestaj </u> </h1>
                
                <table style="width:100%">
                    <tr>
                        <th></th>
                        <th>Broj dokumenata</th>
                    </tr>
                    <tr>
                        <td> <b> Resenja:</b> </td>
                        <td> <xsl:value-of select="/Izvestaj/@resenja"></xsl:value-of> </td>
                    </tr>
                    <tr>
                        <td> <b> Svi zahtevi:</b> </td>
                        <td> <xsl:value-of select="/Izvestaj/@sviZahtevi"></xsl:value-of> </td>
                    </tr>
                    <tr>
                        <td> <b> Odbijeni zahtevi:</b> </td>
                        <td> <xsl:value-of select="/Izvestaj/@odbijeniZahtevi"></xsl:value-of> </td>
                    </tr>
                    <tr>
                        <td> <b> Odobreni zahtevi: </b> </td>
                        <td> <xsl:value-of select="/Izvestaj/@odobreniZahtevi"></xsl:value-of> </td>
                    </tr>
                    <tr>
                        <td> <b>  Sve zalbe: </b> </td>
                        <td> <xsl:value-of select="/Izvestaj/@sveZalbe"></xsl:value-of> </td>
                    </tr>
                    <tr>
                        <td> <b> Zalbe na odluku:</b> </td>
                        <td> <xsl:value-of select="/Izvestaj/@zalbeNaOdluku"></xsl:value-of> </td>
                    </tr>
                    <tr>
                        <td> <b> Zalbe na cutanje:</b> </td>
                        <td> <xsl:value-of select="/Izvestaj/@zalbeNaCutanje"></xsl:value-of> </td>
                    </tr>
                    
                </table> 
     
            </body>
        </html>  
    </xsl:template>
    
</xsl:stylesheet>