<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
    xmlns:b="http://www.ftn.uns.ac.rs/xpath/examples" 
    xmlns:fo="http://www.w3.org/1999/XSL/Format" version="2.0">
    
    <xsl:template match="/">
        <fo:root>
            <fo:layout-master-set>
                <fo:simple-page-master master-name="izvestaj-page">
                    <fo:region-body margin="0.75in"/>
                </fo:simple-page-master>
            </fo:layout-master-set>
            
            <fo:page-sequence master-reference="izvestaj-page">
                <fo:flow flow-name="xsl-region-body">
                    
                    <fo:block font-family="Times New Roman" font-size="24px" font-weight="bold" padding="10px">
                        Godisnji izvestaj
                    </fo:block>
                    
                    <fo:block>
                        <fo:table font-family="serif" margin="5px auto 50px auto" border="1px">
                            <fo:table-column column-width="50%"/>
                            <fo:table-column column-width="50%"/>
                            <fo:table-body>
                                <fo:table-row border="1px solid">
                                    <fo:table-cell padding="10px">
                                        <fo:block font-family="Times New Roman" text-align="center"	font-size="1pt">
                                            
                                        </fo:block>
                                    </fo:table-cell>
                                    
                                    <fo:table-cell padding="10px">
                                        <fo:block font-family="Times New Roman" text-align="center"	font-size="12pt" font-weight="bold">
                                            Broj dokumenata
                                        </fo:block>
                                    </fo:table-cell>
                                </fo:table-row>
                                
                                <fo:table-row border="1px solid">
                                    <fo:table-cell padding="10px">
                                        <fo:block font-family="Times New Roman" text-align="center"	font-size="1pt" font-weight="bold">
                                            Resenja:
                                        </fo:block>
                                    </fo:table-cell>
                                    
                                    <fo:table-cell padding="10px">
                                        <fo:block font-family="Times New Roman" text-align="center"	font-size="12pt">
                                            <xsl:value-of select="/Izvestaj/@resenja"></xsl:value-of>
                                        </fo:block>
                                    </fo:table-cell>
                                </fo:table-row>
                                
                                <fo:table-row border="1px solid">
                                    <fo:table-cell padding="10px">
                                        <fo:block font-family="Times New Roman" text-align="center"	font-size="1pt" font-weight="bold">
                                            Svi zahtevi:
                                        </fo:block>
                                    </fo:table-cell>
                                    
                                    <fo:table-cell padding="10px">
                                        <fo:block font-family="Times New Roman" text-align="center"	font-size="12pt">
                                            <xsl:value-of select="/Izvestaj/@sviZahtevi"></xsl:value-of>
                                        </fo:block>
                                    </fo:table-cell>
                                </fo:table-row>
                                
                                <fo:table-row border="1px solid">
                                    <fo:table-cell padding="10px">
                                        <fo:block font-family="Times New Roman" text-align="center"	font-size="1pt" font-weight="bold">
                                            Odbijeni zahtevi:
                                        </fo:block>
                                    </fo:table-cell>
                                    
                                    <fo:table-cell padding="10px">
                                        <fo:block font-family="Times New Roman" text-align="center"	font-size="12pt">
                                            <xsl:value-of select="/Izvestaj/@odbijeniZahtevi"></xsl:value-of>
                                        </fo:block>
                                    </fo:table-cell>
                                </fo:table-row>
                                
                                <fo:table-row border="1px solid">
                                    <fo:table-cell padding="10px">
                                        <fo:block font-family="Times New Roman" text-align="center"	font-size="1pt" font-weight="bold">
                                            Odobreni zahtevi:
                                        </fo:block>
                                    </fo:table-cell>
                                    
                                    <fo:table-cell padding="10px">
                                        <fo:block font-family="Times New Roman" text-align="center"	font-size="12pt">
                                            <xsl:value-of select="/Izvestaj/@odobreniZahtevi"></xsl:value-of>
                                        </fo:block>
                                    </fo:table-cell>
                                </fo:table-row>
                                
                                <fo:table-row border="1px solid">
                                    <fo:table-cell padding="10px">
                                        <fo:block font-family="Times New Roman" text-align="center"	font-size="1pt" font-weight="bold">
                                            Sve zalbe:
                                        </fo:block>
                                    </fo:table-cell>
                                    
                                    <fo:table-cell padding="10px">
                                        <fo:block font-family="Times New Roman" text-align="center"	font-size="12pt">
                                            <xsl:value-of select="/Izvestaj/@sveZalbe"></xsl:value-of>
                                        </fo:block>
                                    </fo:table-cell>
                                </fo:table-row>
                                
                                <fo:table-row border="1px solid">
                                    <fo:table-cell padding="10px">
                                        <fo:block font-family="Times New Roman" text-align="center"	font-size="1pt" font-weight="bold">
                                            Zalbe na odluku:
                                        </fo:block>
                                    </fo:table-cell>
                                    
                                    <fo:table-cell padding="10px">
                                        <fo:block font-family="Times New Roman" text-align="center"	font-size="12pt">
                                            <xsl:value-of select="/Izvestaj/@zalbeNaOdluku"></xsl:value-of>
                                        </fo:block>
                                    </fo:table-cell>
                                </fo:table-row>
                                
                                <fo:table-row border="1px solid">
                                    <fo:table-cell padding="10px">
                                        <fo:block font-family="Times New Roman" text-align="center"	font-size="1pt" font-weight="bold">
                                            Zalbe na cutanje:
                                        </fo:block>
                                    </fo:table-cell>
                                    
                                    <fo:table-cell padding="10px">
                                        <fo:block font-family="Times New Roman" text-align="center"	font-size="12pt">
                                            <xsl:value-of select="/Izvestaj/@zalbeNaCutanje"></xsl:value-of>
                                        </fo:block>
                                    </fo:table-cell>
                                </fo:table-row>
                                
                            </fo:table-body>
                        </fo:table>
                    </fo:block>
                </fo:flow>
            </fo:page-sequence>
        </fo:root>
    </xsl:template>
</xsl:stylesheet>