<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet
    xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
    xmlns:fo="http://www.w3.org/1999/XSL/Format"
    xmlns:xs="http://www.w3.org/2001/XMLSchema" version="2.0">
    <xsl:template match="/">
        <fo:root font-family="Arial" font-size="12pt">
            <fo:layout-master-set>
                <fo:simple-page-master
                    master-name="obavestenje-page">
                    <fo:region-body margin-top="2.5cm" margin-bottom="2.5cm" margin-left="2.5cm" margin-right="2.5cm" />
                </fo:simple-page-master>
            </fo:layout-master-set>
            
            <fo:page-sequence master-reference="obavestenje-page" language="sr" country="rs">
                <fo:flow flow-name="xsl-region-body">
                    
                    <fo:block-container  text-align="left" margin-bottom="20pt">
                        <fo:block text-decoration="underline">
                            <xsl:value-of select="/Obavestenje/Osnovni_podaci/Organ/Naziv"></xsl:value-of>
                        </fo:block>
                        <fo:block text-decoration="underline">
                            <xsl:value-of select="/Obavestenje/Osnovni_podaci/Organ/Sediste"></xsl:value-of>
                        </fo:block>
                        <fo:block>
                            (назив и седиште органа) 
                        </fo:block>
                    </fo:block-container>
                    
                    <fo:block-container  text-align="left" margin-bottom="20pt">
                        <fo:block>
                            Број предмета: 
                            <fo:inline text-decoration="underline">
                                <xsl:value-of select="/Obavestenje/Osnovni_podaci/Broj_predmeta"></xsl:value-of>
                            </fo:inline>        
                        </fo:block>
                        <fo:block>
                            Датум:
                            <fo:inline text-decoration="underline">
                                <xsl:value-of select="/Obavestenje/Osnovni_podaci/Datum"></xsl:value-of>
                            </fo:inline>
                        </fo:block>
                    </fo:block-container>
                    
                    <fo:block-container  text-align="left" margin-bottom="20pt">
                        <fo:block text-decoration="underline">
                            <xsl:value-of select="/Obavestenje/Osnovni_podaci/Podnosioc_zahteva/Ime"></xsl:value-of> 
                            <xsl:value-of select="/Obavestenje/Osnovni_podaci/Podnosioc_zahteva/Prezime"></xsl:value-of>
                        </fo:block>
                        <fo:block text-decoration="underline">
                            <xsl:value-of select="/Obavestenje/Osnovni_podaci/Podnosioc_zahteva/Naziv"></xsl:value-of>
                        </fo:block>
                        <fo:block text-decoration="underline">
                            <xsl:value-of select="/Obavestenje/Osnovni_podaci/Podnosioc_zahteva/Adresa"></xsl:value-of>
                        </fo:block>
                        <fo:block>
                            (Име и презиме / назив / и адреса подносиоца захтева) 
                        </fo:block>
                    </fo:block-container>
                    
                    <fo:block-container  text-align="center" margin-bottom="30pt">
                        <fo:block font-size="2em">       
                            О Б А В Е Ш Т Е Њ Е 
                        </fo:block>
                        <fo:block font-size="1.5em">
                            о стављању на увид документа који садржи
                        </fo:block>
                        <fo:block font-size="1.5em">
                            тражену информацију и о изради копије
                        </fo:block>
                    </fo:block-container>
                    
                    <fo:block-container text-align="justify" margin-bottom="30pt">
                        <fo:block>
                            На основу члана 16. ст. 1. Закона о слободном приступу информацијама од
                            јавног значаја, поступајући по вашем захтеву за слободан приступ 
                            информацијама од 
                            <fo:inline text-decoration="underline"> 
                                <xsl:value-of select="/Obavestenje/Sadrzaj/Paragraf/Godina"></xsl:value-of> 
                            </fo:inline>
                            год., којим сте тражили увид у документ/е са
                            информацијама о / у вези са: 
                        </fo:block>    
                        <fo:block text-decoration="underline">
                            <xsl:value-of select="/Obavestenje/Sadrzaj/Paragraf/Opis_informacije"></xsl:value-of>
                        </fo:block>
                        <fo:block text-align="center" margin-bottom="20pt">
                            (опис тражене информације)
                        </fo:block>
                        
                        <fo:block margin-bottom="20pt">
                            обавештавамо вас да дана 
                            <fo:inline text-decoration="underline"> <xsl:value-of select="/Obavestenje/Sadrzaj/Paragraf/Datum_uvida"></xsl:value-of> </fo:inline> у 
                            <fo:inline text-decoration="underline"> <xsl:value-of select="/Obavestenje/Sadrzaj/Paragraf/Vreme_uvida"></xsl:value-of> </fo:inline> часова, 
                            односно у времену од 
                            <fo:inline text-decoration="underline"> <xsl:value-of select="/Obavestenje/Sadrzaj/Paragraf/Pocetak_cas"></xsl:value-of> </fo:inline> до
                            <fo:inline text-decoration="underline"> <xsl:value-of select="/Obavestenje/Sadrzaj/Paragraf/Kraj_cas"></xsl:value-of> </fo:inline> часова, у просторијама органа у
                            <fo:inline text-decoration="underline"> <xsl:value-of select="/Obavestenje/Sadrzaj/Paragraf/Grad_organa"></xsl:value-of> </fo:inline> ул.
                            <fo:inline text-decoration="underline"> <xsl:value-of select="/Obavestenje/Sadrzaj/Paragraf/Ulica_organa"></xsl:value-of> </fo:inline> бр.
                            <fo:inline text-decoration="underline">  <xsl:value-of select="/Obavestenje/Sadrzaj/Paragraf/Broj_organa"></xsl:value-of> </fo:inline>, канцеларија бр. 
                            <fo:inline> <xsl:value-of select="/Obavestenje/Sadrzaj/Paragraf/Broj_kancelarije"></xsl:value-of> </fo:inline>
                            можете <fo:inline  font-weight="bold"> извршити увид </fo:inline> у документ/е у коме је садржана тражена информација. 
                        </fo:block>
                        
                        <fo:block margin-bottom="20pt">
                            Том приликом, на ваш захтев, може вам се издати и копија документа са траженом информацијом. 
                        </fo:block>
                        
                        <fo:block margin-bottom="20pt">
                            Трошкови су утврђени Уредбом Владе Републике Србије („Сл. гласник РС“, бр. 8/06), и то: копија стране А4
                            формата износи 3 динара, А3 формата 6 динара, CD 35 динара, дискете 20 динара, DVD 40 динара,
                            аудио-касета – 150 динара, видео-касета 300 динара, претварање једне стране документа из физичког
                            у електронски облик – 30 динара.
                        </fo:block>
                        
                        <fo:block>
                            Износ укупних трошкова израде копије документа по вашем захтеву износи 
                            <fo:inline text-decoration="underline"> <xsl:value-of select="/Obavestenje/Sadrzaj/Paragraf/Iznos_troskova"></xsl:value-of> </fo:inline>
                            динара и уплаћује се на жиро-рачун Буџета Републике Србије бр. 840-742328-843-30, 
                            с позивом на број 97 – ознака шифре
                            општине/града где се налази орган власти (из Правилника о условима и начину вођења рачуна – 
                            „Сл. гласник РС“, 20/07... 40/10). 
                        </fo:block>
                    </fo:block-container>
                    
                    <fo:block-container text-align="left">
                        <fo:block>
                            Достављено:
                        </fo:block>
                        <fo:list-block>
                            <xsl:if test="/Obavestenje/Sadrzaj/Dostavljeno/@Selected='1'">
                                <fo:list-item font-weight="bolder">
                                    <fo:list-item-label>
                                        <fo:block>1.</fo:block>
                                    </fo:list-item-label>
                                    <fo:list-item-body>
                                        <fo:block>Именованом</fo:block>
                                    </fo:list-item-body>
                                </fo:list-item>
                                
                                <fo:list-item>
                                    <fo:list-item-label>
                                        <fo:block>2.</fo:block>
                                    </fo:list-item-label>
                                    <fo:list-item-body>
                                        <fo:block>Архиви</fo:block>
                                    </fo:list-item-body>
                                </fo:list-item>
                            </xsl:if>
                            <xsl:if test="/Obavestenje/Sadrzaj/Dostavljeno/@Selected='2'">
                                <fo:list-item>
                                    <fo:list-item-label>
                                        <fo:block>1.</fo:block>
                                    </fo:list-item-label>
                                    <fo:list-item-body>
                                        <fo:block>Именованом</fo:block>
                                    </fo:list-item-body>
                                </fo:list-item>
                                
                                <fo:list-item font-weight="bolder">
                                    <fo:list-item-label>
                                        <fo:block>2.</fo:block>
                                    </fo:list-item-label>
                                    <fo:list-item-body>
                                        <fo:block>Архиви</fo:block>
                                    </fo:list-item-body>
                                </fo:list-item>
                            </xsl:if>
                        </fo:list-block>
                    </fo:block-container>
                    
                </fo:flow>
            </fo:page-sequence>
        </fo:root>
    </xsl:template>
</xsl:stylesheet>