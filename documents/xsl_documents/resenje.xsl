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
                    margin-bottom: 20px;
                    }
                    
                    .half{
                    width: 40%;
                    }
                    
                    .right {
                    text-align: right;
                    }
                    
                    .center {
                    text-align: center;
                    }
                    
                    .justify {
                    text-align: justify;
                    }
                </style>
            </head>
            
            <body>
                <p class="add-space-after"> 
                    <xsl:value-of select="/Resenje_obrazac/Datum"></xsl:value-of>
                </p>
                <p class="justify indented add-space-after">
                    <xsl:value-of select="/Resenje_obrazac/Uvod"></xsl:value-of>
                </p>
                
                <h1 class="center"> Р Е Ш Е Њ Е </h1>
                
                <p class="justify indented add-space-after">
                    <xsl:value-of select="/Resenje_obrazac/Sadrzaj/Resenje/Pasus[1]"></xsl:value-of>
                </p>
                <p class="justify indented add-space-after">
                    <xsl:value-of select="/Resenje_obrazac/Sadrzaj/Resenje/Pasus[2]"></xsl:value-of>
                </p>
                
                <h2 class="center"> О б р а з л о ж е њ е </h2>
                
                <p class="justify indented add-space-after">
                    <xsl:value-of select="/Resenje_obrazac/Sadrzaj/Obrazlozenje/Sadrzaj_obrazlozenja"></xsl:value-of>
                </p>
                
                <div class="right add-space-after">
                    <p> ПОВЕРЕНИК </p>
                    <p>
                        <xsl:value-of select="/Resenje_obrazac/Poverenik/Ime"></xsl:value-of> 
                        <xsl:value-of select="/Resenje_obrazac/Poverenik/Prezime"></xsl:value-of>
                    </p>
                </div>
                
            </body>
        </html>  
    </xsl:template>
    
</xsl:stylesheet>