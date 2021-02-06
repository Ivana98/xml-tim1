<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet 
    xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
    xmlns:fo="http://www.w3.org/1999/XSL/Format"
    xmlns:ns2="http://www.ftn.uns.ac.rs/resenje"
    xmlns:xs="http://www.w3.org/2001/XMLSchema" version="2.0">
    <xsl:template match="/">
        <fo:root>
            <fo:layout-master-set>
                <fo:simple-page-master
                    master-name="resenje-page">
                    <fo:region-body margin-top="0.75in"
                        margin-bottom="0.75in" margin-left="80pt" margin-right="80pt" />
                </fo:simple-page-master>
            </fo:layout-master-set>
            
            <fo:page-sequence master-reference="resenje-page">
                <fo:flow flow-name="xsl-region-body">
                    <fo:block font-family="Times New Roman" width="60%"
                        text-align-last="justify" border="none">
                        Број: 
                        <fo:inline  font-family="Times New Roman" font-size="10pt"
                            font-weight="bold" text-align="center">
                            <xsl:value-of select="/ns2:Resenje_obrazac/@broj"></xsl:value-of>
                        </fo:inline>
                        <fo:leader leader-pattern="space" />
                        <fo:inline font-family="Times New Roman" width="60%" text-align="right" border="none">
                            Датум: 
                            <fo:inline  font-family="Times New Roman" font-size="10pt"
                                font-weight="bold" text-align="center">
                                <xsl:value-of select="/ns2:Resenje_obrazac/ns2:Datum"></xsl:value-of>
                            </fo:inline>
                            године.
                        </fo:inline>
                    </fo:block>
                    <fo:block font-family="Times New Roman" width="60%"
                        margin-top="10pt" text-align="justify" border="none" text-indent="40px">
                        <xsl:value-of select="/ns2:Resenje_obrazac/ns2:Uvod"></xsl:value-of>
                    </fo:block>
                    
                    <fo:block font-family="Times New Roman" width="60%" font-size="15pt" margin-top="10pt" margin-bottom="10pt" text-align="center" border="none">
                        Р Е Ш Е Њ Е
                    </fo:block>
                    <fo:block font-family="Times New Roman" width="60%"
                        margin-top="10pt" text-align="justify" border="none" text-indent="40px">
                        <xsl:value-of select="/ns2:Resenje_obrazac/ns2:Sadrzaj/ns2:Resenje/ns2:Pasus[1]"></xsl:value-of>
                    </fo:block>
                    <fo:block font-family="Times New Roman" width="60%"
                        margin-top="10pt" text-align="justify" border="none" text-indent="40px">
                        <xsl:value-of select="/ns2:Resenje_obrazac/ns2:Sadrzaj/ns2:Resenje/ns2:Pasus[2]"></xsl:value-of>
                    </fo:block>
                    
                    <fo:block font-family="Times New Roman" width="60%" font-size="12pt" margin-top="10pt" margin-bottom="10pt" text-align="center" border="none">
                        O б р а з л о ж е њ е
                    </fo:block>
                    <fo:block font-family="Times New Roman" width="60%"
                        margin-top="10pt" text-align="justify" border="none" text-indent="40px">
                        <xsl:value-of select="/ns2:Resenje_obrazac/ns2:Sadrzaj/ns2:Obrazlozenje/ns2:Sadrzaj_obrazlozenja"></xsl:value-of>
                    </fo:block>
                    
                    <fo:block font-family="Times New Roman" width="60%"
                        margin-top="10pt" text-align="right" border="none">
                        ПОВЕРЕНИК
                    </fo:block>
                    <fo:block font-family="Times New Roman" width="60%"
                        text-align="right" border="none">
                        <xsl:value-of select="/ns2:Resenje_obrazac/ns2:Poverenik/ns2:Ime"></xsl:value-of> 
                        <xsl:value-of select="/ns2:Resenje_obrazac/ns2:Poverenik/ns2:Prezime"></xsl:value-of>
                    </fo:block>
                </fo:flow>
            </fo:page-sequence>
            
        </fo:root>
    </xsl:template>
</xsl:stylesheet>