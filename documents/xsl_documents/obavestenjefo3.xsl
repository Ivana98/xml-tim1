<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet
    xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
    xmlns:ns2="http://www.ftn.uns.ac.rs/obavestenjecir"
    xmlns:fo="http://www.w3.org/1999/XSL/Format"
    xmlns:xs="http://www.w3.org/2001/XMLSchema" version="2.0">
    <xsl:template match="/">
        <fo:root>
            <fo:layout-master-set>
                <fo:simple-page-master
                    master-name="obavestenje-page">
                    <fo:region-body margin-top="0.75in"
                        margin-bottom="0.75in" margin-left="80pt" margin-right="80pt" />
                </fo:simple-page-master>
            </fo:layout-master-set>
            
            <fo:page-sequence master-reference="obavestenje-page">
                <fo:flow flow-name="xsl-region-body">
                    <fo:block font-family="Times New Roman" margin-top="30pt"
                        font-size="11pt" text-align="left" text-decoration="underline">
                        <xsl:value-of select="/ns2:Obavestenje/ns2:Osnovni_podaci/ns2:Organ/ns2:Naziv"></xsl:value-of>
                    </fo:block>
                    <fo:block font-family="Times New Roman" text-align="left"
                        font-size="11pt" text-decoration="underline">
                        <xsl:value-of select="/ns2:Obavestenje/ns2:Osnovni_podaci/ns2:Organ/ns2:Sediste"></xsl:value-of>
                    </fo:block>
                    <fo:block font-family="Times New Roman" text-align="left"
                        font-size="11pt">
                        (назив и седиште органа)
                    </fo:block>
                    <fo:block font-family="Times New Roman" text-align="left"
                        font-size="11pt" text-decoration="underline">
                        Број предмета:
                        <xsl:value-of select="/ns2:Obavestenje/ns2:Osnovni_podaci/ns2:Broj_predmeta"></xsl:value-of>
                    </fo:block>
                    <fo:block font-family="Times New Roman" text-align="left"
                        font-size="11pt">
                        Датум:
                        <fo:inline text-indent="8em" text-decoration="underline">
                            <xsl:value-of select="/ns2:Obavestenje/ns2:Osnovni_podaci/ns2:Datum"></xsl:value-of>
                        </fo:inline>
                    </fo:block>
                    <fo:block font-family="Times New Roman" text-align="left"
                        font-size="11pt" margin-top="11pt" text-decoration="underline">
                        <xsl:value-of select="/ns2:Obavestenje/ns2:Osnovni_podaci/ns2:Podnosioc_zahteva/ns2:Ime"></xsl:value-of> 
                        <xsl:value-of select="/ns2:Obavestenje/ns2:Osnovni_podaci/ns2:Podnosioc_zahteva/ns2:Prezime"></xsl:value-of>
                    </fo:block>
                    <fo:block font-family="Times New Roman" text-align="left"
                        font-size="11pt" text-decoration="underline">
                        <xsl:value-of select="/ns2:Obavestenje/ns2:Osnovni_podaci/ns2:Podnosioc_zahteva/ns2:Naziv"></xsl:value-of>
                    </fo:block>
                    <fo:block font-family="Times New Roman" text-align="left"
                        font-size="11pt" text-decoration="underline">
                        <xsl:value-of select="/ns2:Obavestenje/ns2:Osnovni_podaci/ns2:Podnosioc_zahteva/ns2:Adresa"></xsl:value-of>
                    </fo:block>
                    <fo:block font-family="Times New Roman" text-align="left"
                        font-size="11pt">
                        Име и презиме / назив / и адреса подносиоца захтева
                    </fo:block>
                    <fo:block font-family="Times New Roman"
                        text-align="center" font-size="12pt" margin-top="22pt"
                        font-weight="bold">
                        О Б А В Е Ш Т Е Њ Е
                    </fo:block>
                    <fo:block font-family="Times New Roman"
                        text-align="center" font-size="12pt" margin-top="5pt"
                        font-weight="bold">
                        о стављању на
                        увид документа
                    </fo:block>
                    
                    <fo:block font-family="Times New Roman"
                        text-align="justify" font-size="11pt" margin-top="11pt"
                        text-indent="4em">
                        На основу члана 16. ст. 1. Закона о слободном приступу
                        информацијама
                        од јавног значаја, поступајући по вашем захтеву за
                        слободан
                        приступ информацијама од
                        <fo:inline text-decoration="underline" >
                            <xsl:value-of select="/ns2:Obavestenje/ns2:Sadrzaj/ns2:Paragraf/ns2:Godina"></xsl:value-of>
                        </fo:inline>
                        год., којим сте тражили увид у
                        документ/е са информацијама о / у
                        вези са:
                    </fo:block>
                    <fo:block font-family="Times New Roman"
                        text-align="center" font-size="11pt" text-decoration="underline" margin-top="20pt">
                        <xsl:value-of select="/ns2:Obavestenje/ns2:Sadrzaj/ns2:Paragraf/ns2:Opis_informacije"></xsl:value-of>
                    </fo:block>
                    <fo:block font-family="Times New Roman"
                        text-align="center" font-size="11pt">
                        (опис тражене информације)
                    </fo:block>
                    <fo:block font-family="Times New Roman"
                        text-align="justify" font-size="11pt" text-indent="4em"
                        margin-top="11pt">
                        Oбавештавамо вас да дана
                        <fo:inline text-decoration="underline">
                            <xsl:value-of select="/ns2:Obavestenje/ns2:Sadrzaj/ns2:Paragraf/ns2:Datum_uvida"></xsl:value-of>
                        </fo:inline>
                        ,
                        у
                        <fo:inline text-decoration="underline">
                            <xsl:value-of select="/ns2:Obavestenje/ns2:Sadrzaj/ns2:Paragraf/ns2:Vreme_uvida"></xsl:value-of>
                        </fo:inline>
                        
                        часова,
                        односно у времену
                        од
                        <fo:inline text-decoration="underline">
                            <xsl:value-of select="/ns2:Obavestenje/ns2:Sadrzaj/ns2:Paragraf/ns2:Pocetak_cas"></xsl:value-of>
                        </fo:inline>
                        до
                        <fo:inline text-decoration="underline">
                            <xsl:value-of select="/ns2:Obavestenje/ns2:Sadrzaj/ns2:Paragraf/ns2:Kraj_cas"></xsl:value-of>
                        </fo:inline>
                        
                        часова, у просторијама органа у
                        <fo:inline text-decoration="underline">
                            <xsl:value-of select="/ns2:Obavestenje/ns2:Sadrzaj/ns2:Paragraf/ns2:Grad_organa"></xsl:value-of>
                        </fo:inline>
                        ул.
                        <fo:inline text-decoration="underline">
                            <xsl:value-of select="/ns2:Obavestenje/ns2:Sadrzaj/ns2:Paragraf/ns2:Ulica_organa"></xsl:value-of>
                        </fo:inline>
                        бр.
                        <fo:inline text-decoration="underline">
                            <xsl:value-of select="/ns2:Obavestenje/ns2:Sadrzaj/ns2:Paragraf/ns2:Broj_organa"></xsl:value-of>
                        </fo:inline>
                        ,
                        канцеларија бр.
                        <fo:inline text-decoration="underline">
                            <xsl:value-of select="/ns2:Obavestenje/ns2:Sadrzaj/ns2:Paragraf/ns2:Broj_kancelarije"></xsl:value-of>
                        </fo:inline>
                        можете
                        <fo:inline font-weight="bold">извршити увид</fo:inline>
                        у документ/е у коме је садржана тражена
                        информација.
                    </fo:block>
                    <fo:block font-family="Times New Roman"
                        text-align="justify" font-size="11pt" text-indent="4em"
                        margin-top="11pt">
                        Том приликом, на ваш захтев, може вам се издати и копија документа са траженом информацијом.
                    </fo:block>
                    <fo:block font-family="Times New Roman"
                        text-align="justify" font-size="11pt" margin-top="11pt">
                        Трошкови су утврђени Уредбом Владе Републике Србије („Сл. гласник
                        РС“, бр. 8/06), и то:
                        копија стране А4 формата износи 3 динара, А3 формата 6 динара, CD 35 динара, дискете 20 динара, DVD 40 динара, 
                        аудио-касета – 150 динара, видео-касета 300 динара, претварање једне стране документа из физичког у електронски облик – 30 динара.
                    </fo:block>
                    <fo:block font-family="Times New Roman"
                        text-align="justify" font-size="11pt" text-indent="4em"
                        margin-top="11pt">
                        Износ укупних трошкова износи
                        <fo:inline text-decoration="underline">
                            <xsl:value-of select="/ns2:Obavestenje/ns2:Sadrzaj/ns2:Paragraf/ns2:Iznos_troskova"></xsl:value-of>
                        </fo:inline>
                        динара и уплаћује се на жиро-рачун Буџета Републике Србије бр. 840-742328-843-30, 
                        с позивом на број 97 – ознака шифре
                        општине/града где се налази орган власти (из Правилника о условима и начину вођења рачуна – 
                        „Сл. гласник РС“, 20/07... 40/10). 
                    </fo:block>
                    
                    <fo:block font-family="Times New Roman" text-align="left"
                        font-size="11pt" margin-top="11pt">
                        Достављено:
                    </fo:block>

                    <fo:list-block>
                        
                        <xsl:if test="/ns2:Obavestenje/ns2:Sadrzaj/ns2:Dostavljeno/@Selected='1'">
                            <fo:list-item text-decoration="underline">
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
                        
                        <xsl:if test="/ns2:Obavestenje/ns2:Sadrzaj/ns2:Dostavljeno/@Selected='2'">
                            <fo:list-item>
                                <fo:list-item-label>
                                    <fo:block>1.</fo:block>
                                </fo:list-item-label>
                                <fo:list-item-body>
                                    <fo:block>Именованом</fo:block>
                                </fo:list-item-body>
                            </fo:list-item>
                            
                            <fo:list-item text-decoration="underline">
                                <fo:list-item-label>
                                    <fo:block>2.</fo:block>
                                </fo:list-item-label>
                                <fo:list-item-body>
                                    <fo:block>Архиви</fo:block>
                                </fo:list-item-body>
                            </fo:list-item>
                        </xsl:if>
                        
                    </fo:list-block>
                    
                </fo:flow>
            </fo:page-sequence>
        </fo:root>
    </xsl:template>
</xsl:stylesheet>