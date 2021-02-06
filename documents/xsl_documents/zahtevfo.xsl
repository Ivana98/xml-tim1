<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet
    xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
    xmlns:ns2="http://www.ftn.uns.ac.rs/zahtev"
    xmlns:fo="http://www.w3.org/1999/XSL/Format"
    xmlns:xs="http://www.w3.org/2001/XMLSchema" version="2.0">
    
    <xsl:template match="/">
        <fo:root>
            <fo:layout-master-set>
                <fo:simple-page-master
                    master-name="zahtev-page">
                    <fo:region-body margin-top="0.75in"
                        margin-bottom="0.75in" margin-left="80pt" margin-right="80pt" />
                </fo:simple-page-master>
            </fo:layout-master-set>
            
            <fo:page-sequence master-reference="zahtev-page">
                <fo:flow flow-name="xsl-region-body">
                    <fo:block font-family="Times New Roman" width="60%"
                        margin-top="10pt" text-align="center" border="none"  text-decoration="underline">
                        <xsl:value-of select="/ns2:zahtev/ns2:info_organa/ns2:naziv"></xsl:value-of>
                        ,
                        <xsl:value-of select="/ns2:zahtev/ns2:info_organa/ns2:sediste"></xsl:value-of>
                    </fo:block>
                    <fo:block margin-top="0pt" margin-bottom="0pt"
                        text-align="center" font-size="12pt" font-family="Times New Roman">
                        (назив и седиште органа коме се захтев упућује)
                    </fo:block>
                    
                    <fo:block font-family="Times New Roman" font-size="14pt" font-weight="bold" text-align="center" margin-top="48pt">
                        З А Х Т Е В
                    </fo:block>
                    <fo:block font-family="Times New Roman" font-size="14pt" font-weight="bold" text-align="center">
                        за приступ информацији од јавног значаја
                    </fo:block>
                    <fo:block font-family="Times New Roman" font-size="12pt"
                        text-align="justify" text-indent="4em" margin-top="28pt">
                        На основу члана 15. ст. 1. Закона о слободном приступу информацијама од
                        јавног значаја („Службени гласник РС“, бр. 120/04, 54/07, 104/09 и 36/10),
                        од горе наведеног органа захтевам:*
                    </fo:block>
                    
                    <xsl:for-each select="/ns2:zahtev/ns2:opis_zahteva/ns2:tipovi_zahteva/ns2:tip_zahteva">
                        <xsl:choose>
                            <xsl:when test="@rb = '1'">
                                <xsl:choose>
                                    <xsl:when test="@selektovan = 'true'">
                                        <fo:block font-family="Times New Roman" font-size="14pt" font-weight="bold" text-align="left">
                                            обавештење да ли поседује тражену информацију;
                                        </fo:block>
                                    </xsl:when>
                                </xsl:choose>
                                <xsl:choose>
                                    <xsl:when test="@selektovan = 'false'">
                                        <fo:block font-family="Times New Roman" font-size="14pt" text-align="left">
                                            обавештење да ли поседује тражену информацију;
                                        </fo:block>
                                    </xsl:when>
                                </xsl:choose>
                            </xsl:when>
                        </xsl:choose>
                            
                        <xsl:choose>
                            <xsl:when test="@rb = '2'">
                                <xsl:choose>
                                    <xsl:when test="@selektovan = 'true'">
                                        <fo:block font-family="Times New Roman" font-size="14pt" font-weight="bold" text-align="left">
                                            увид у документ који садржи тражену информацију;                                            
                                        </fo:block>
                                    </xsl:when>
                                </xsl:choose>
                                <xsl:choose>
                                    <xsl:when test="@selektovan = 'false'">
                                        <fo:block font-family="Times New Roman" font-size="14pt" text-align="left">
                                            увид у документ који садржи тражену информацију;                                            
                                        </fo:block>
                                    </xsl:when>
                                </xsl:choose>
                            </xsl:when>
                        </xsl:choose>
                        
                        <xsl:choose>
                            <xsl:when test="@rb = '3'">
                                <xsl:choose>
                                    <xsl:when test="@selektovan = 'true'">
                                        <fo:block font-family="Times New Roman" font-size="14pt" font-weight="bold" text-align="left">
                                            копију документа који садржи тражену информацију;  
                                        </fo:block>
                                    </xsl:when>
                                </xsl:choose>
                                <xsl:choose>
                                    <xsl:when test="@selektovan = 'false'">
                                        <fo:block font-family="Times New Roman" font-size="14pt" text-align="left">
                                            копију документа који садржи тражену информацију;    
                                        </fo:block>
                                    </xsl:when>
                                </xsl:choose>
                            </xsl:when>
                        </xsl:choose>
                        
                        <xsl:choose>
                            <xsl:when test="@rb = '4'">
                                <xsl:choose>
                                    <xsl:when test="@selektovan = 'true'">
                                        <fo:block font-family="Times New Roman" font-size="14pt" font-weight="bold" text-align="left">
                                            достављање копије документа који садржи тражену информацију:**
                                        </fo:block>
                                    </xsl:when>
                                </xsl:choose>
                                <xsl:choose>
                                    <xsl:when test="@selektovan = 'false'">
                                        <fo:block font-family="Times New Roman" font-size="14pt" text-align="left">
                                            достављање копије документа који садржи тражену информацију:**
                                        </fo:block>
                                    </xsl:when>
                                </xsl:choose>
                            </xsl:when>
                        </xsl:choose>
                    </xsl:for-each>
                    
                    <xsl:for-each select="/ns2:zahtev/ns2:opis_zahteva/ns2:tipovi_zahteva/ns2:tip_zahteva/ns2:nacini_slanja/ns2:nacin_slanja">
                        <xsl:choose>
                            <xsl:when test="@rb = '1'">
                                <xsl:choose>
                                    <xsl:when test="@selektovan = 'true'">
                                        <fo:block font-family="Times New Roman" font-size="14pt" font-weight="bold" text-align="left">
                                            поштом
                                        </fo:block>
                                    </xsl:when>
                                </xsl:choose>
                                <xsl:choose>
                                    <xsl:when test="@selektovan = 'false'">
                                        <fo:block font-family="Times New Roman" font-size="14pt" text-align="left">
                                            поштом
                                        </fo:block>
                                    </xsl:when>
                                </xsl:choose>
                            </xsl:when>
                        </xsl:choose>
                        
                        <xsl:choose>
                            <xsl:when test="@rb = '2'">
                                <xsl:choose>
                                    <xsl:when test="@selektovan = 'true'">
                                        <fo:block font-family="Times New Roman" font-size="14pt" font-weight="bold" text-align="left">
                                            електронском поштом                                           
                                        </fo:block>
                                    </xsl:when>
                                </xsl:choose>
                                <xsl:choose>
                                    <xsl:when test="@selektovan = 'false'">
                                        <fo:block font-family="Times New Roman" font-size="14pt" text-align="left">
                                            електронском поштом                                           
                                        </fo:block>
                                    </xsl:when>
                                </xsl:choose>
                            </xsl:when>
                        </xsl:choose>
                        
                        <xsl:choose>
                            <xsl:when test="@rb = '3'">
                                <xsl:choose>
                                    <xsl:when test="@selektovan = 'true'">
                                        <fo:block font-family="Times New Roman" font-size="14pt" font-weight="bold" text-align="left">
                                            факсом
                                        </fo:block>
                                    </xsl:when>
                                </xsl:choose>
                                <xsl:choose>
                                    <xsl:when test="@selektovan = 'false'">
                                        <fo:block font-family="Times New Roman" font-size="14pt" text-align="left">
                                            факсом
                                        </fo:block>
                                    </xsl:when>
                                </xsl:choose>
                            </xsl:when>
                        </xsl:choose>
                        
                        <xsl:choose>
                            <xsl:when test="@rb = '4'">
                                <xsl:choose>
                                    <xsl:when test="@selektovan = 'true'">
                                        <fo:block font-family="Times New Roman" font-size="14pt" font-weight="bold" text-align="left">
                                            на други начин:***  
                                            <fo:inline text-decoration="underline">
                                                <xsl:value-of select="."></xsl:value-of>
                                            </fo:inline>
                                        </fo:block>
                                    </xsl:when>
                                </xsl:choose>
                                <xsl:choose>
                                    <xsl:when test="@selektovan = 'false'">
                                        <fo:block font-family="Times New Roman" font-size="14pt" text-align="left">
                                            на други начин:***
                                        </fo:block>
                                    </xsl:when>
                                </xsl:choose>
                            </xsl:when>
                        </xsl:choose>
                    </xsl:for-each>
                    
                    <fo:block font-family="Times New Roman" font-size="12pt"
                        text-align="justify" text-indent="4em" margin-top="12pt">
                        Овај захтев се односи на следеће информације:
                    </fo:block>
                    <fo:block font-family="Times New Roman" font-size="12pt"
                        text-align="justify" text-indent="4em" text-decoration="underline" margin-top="10pt">
                        <xsl:value-of select="/ns2:zahtev/ns2:opis_zahteva/ns2:dodatne_informacije/ns2:opis_dodatne_informacije"></xsl:value-of>
                    </fo:block>
                    <fo:block font-family="Times New Roman" font-size="9pt" text-align="justify">
                        (навести што прецизнији опис информације која се тражи као и друге податке
                        који олакшавају проналажење тражене информације)
                    </fo:block>
                    
                    <fo:block font-family="Times New Roman" font-size="10pt"
                        text-align="right" margin-top="27pt"  text-decoration="underline">
                        <xsl:value-of select="/ns2:zahtev/ns2:trazilac/ns2:ime_i_prezime"></xsl:value-of>
                    </fo:block>
                    <fo:block font-family="Times New Roman" font-size="10pt"
                        text-align="right">
                        (Тражилац информације/Име и презиме)
                    </fo:block>
                    
                    <fo:block font-family="Times New Roman" font-size="10pt"
                        text-align="right" margin-top="10pt"  text-decoration="underline">
                        <xsl:value-of select="/ns2:zahtev/ns2:trazilac/ns2:adresa"></xsl:value-of>
                    </fo:block>
                    <fo:block font-family="Times New Roman" font-size="10pt"
                        text-align="right">
                        (адреса)
                    </fo:block>
                    <fo:block font-family="Times New Roman" font-size="10pt"
                        text-align="right" margin-top="10pt"  text-decoration="underline">
                        <xsl:value-of select="/ns2:zahtev/ns2:trazilac/ns2:kontakt"></xsl:value-of>
                    </fo:block>
                    <fo:block font-family="Times New Roman" font-size="10pt" text-align="right">
                        (други подаци за контакт)
                    </fo:block>
                    
                    <fo:block font-family="Times New Roman" font-size="10pt"
                        text-align="left" margin-top="-50pt"  text-decoration="underline">
                        У
                        <xsl:value-of select="/ns2:zahtev/ns2:mesto"></xsl:value-of>
                        ,
                    </fo:block>
                    <fo:block font-family="Times New Roman" font-size="10pt"
                        text-align="left" margin-top="20pt"  text-decoration="underline">
                        дана
                        <xsl:value-of select="/ns2:zahtev/ns2:datum"></xsl:value-of>. године
                    </fo:block>
                    
                    <fo:block font-family="Times New Roman" font-size="9pt"
                        text-align="justify" margin-top="40pt">
                        ___________________________________________________________________
                    </fo:block>
                    <fo:block font-family="Times New Roman" font-size="9pt"
                        text-align="justify">
                        * У кућици означити која законска права на приступ информацијама желите да остварите.
                    </fo:block>
                    <fo:block font-family="Times New Roman" font-size="9pt"
                        text-align="justify">
                        ** У кућици означити начин достављања копије докумената.
                    </fo:block>
                    <fo:block font-family="Times New Roman" font-size="9pt"
                        text-align="justify">
                        *** Када захтевате други начин достављања обавезно уписати који начин достављања захтевате.
                    </fo:block>
                    
                </fo:flow>
            </fo:page-sequence>
        </fo:root>
    </xsl:template>
</xsl:stylesheet>