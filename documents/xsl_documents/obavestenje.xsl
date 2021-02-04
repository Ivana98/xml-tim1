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
                
                <p> 
                    <u>
                        <xsl:value-of select="/Obavestenje/Osnovni_podaci/Organ/Naziv"></xsl:value-of>
                    </u>
                </p>
                <p> 
                    <u>
                        <xsl:value-of select="/Obavestenje/Osnovni_podaci/Organ/Sediste"></xsl:value-of> 
                    </u>
                </p>
                <small> (назив и седиште органа) </small>
                <p> 
                    Број предмета: 
                    <u>
                        <xsl:value-of select="/Obavestenje/Osnovni_podaci/Broj_predmeta"></xsl:value-of> 
                    </u>
                </p>
                <p class="add-space-after"> 
                    Датум: 
                    <u>
                        <xsl:value-of select="/Obavestenje/Osnovni_podaci/Datum"></xsl:value-of>
                    </u>
                </p>
                
                <p>
                    <u>
                        <xsl:value-of select="/Obavestenje/Osnovni_podaci/Podnosioc_zahteva/Ime"></xsl:value-of> 
                        <xsl:value-of select="/Obavestenje/Osnovni_podaci/Podnosioc_zahteva/Prezime"></xsl:value-of>
                    </u>
                </p>
                <p>
                    <u>
                        <xsl:value-of select="/Obavestenje/Osnovni_podaci/Podnosioc_zahteva/Naziv"></xsl:value-of> 
                    </u>
                </p>
                <p>
                    <u>
                        <xsl:value-of select="/Obavestenje/Osnovni_podaci/Podnosioc_zahteva/Adresa"></xsl:value-of> 
                    </u>
                </p>
                <small class="add-space-after"> (Име и презиме / назив / и адреса подносиоца захтева) </small>
                
                <h1 class="center"> О Б А В Е Ш Т Е Њ Е </h1>
                <h2 class="add-space-after center"> о стављању на увид документа који садржи <br></br>
                    тражену информацију и о изради копије
                </h2>
                
                <p class="indented justify">
                    На основу члана 16. ст. 1. Закона о слободном приступу информацијама од
                    јавног значаја, поступајући по вашем захтеву за слободан приступ 
                    информацијама од 
                    <u> <xsl:value-of select="/Obavestenje/Sadrzaj/Paragraf/Godina"></xsl:value-of> </u>
                    год., којим сте тражили увид у документ/е са
                    информацијама о / у вези са: 
                </p>
                <p class="justify">
                    <u>
                        <xsl:value-of select="/Obavestenje/Sadrzaj/Paragraf/Opis_informacije"></xsl:value-of>
                    </u>
                </p>
                <small class="add-space-after center"> (опис тражене информације) </small>
                
                <p class="add-space-after justify">
                    обавештавамо вас да дана 
                    <u> <xsl:value-of select="/Obavestenje/Sadrzaj/Paragraf/Datum_uvida"></xsl:value-of> </u> у 
                    <u> <xsl:value-of select="/Obavestenje/Sadrzaj/Paragraf/Vreme_uvida"></xsl:value-of> </u> часова, 
                    односно у времену од 
                    <u> <xsl:value-of select="/Obavestenje/Sadrzaj/Paragraf/Pocetak_cas"></xsl:value-of> </u> до
                    <u> <xsl:value-of select="/Obavestenje/Sadrzaj/Paragraf/Kraj_cas"></xsl:value-of> </u> часова, у просторијама органа у
                    <u> <xsl:value-of select="/Obavestenje/Sadrzaj/Paragraf/Grad_organa"></xsl:value-of> </u> ул.
                    <u> <xsl:value-of select="/Obavestenje/Sadrzaj/Paragraf/Ulica_organa"></xsl:value-of> </u> бр.
                    <u>  <xsl:value-of select="/Obavestenje/Sadrzaj/Paragraf/Broj_organa"></xsl:value-of> </u>, канцеларија бр. 
                    <u> <xsl:value-of select="/Obavestenje/Sadrzaj/Paragraf/Broj_kancelarije"></xsl:value-of> </u>
                    можете <b> извршити увид </b> у документ/е у коме је садржана тражена информација. 
                </p>
                <p class="indented add-space-after justify"> Том приликом, на ваш захтев, може вам се издати и копија документа са траженом информацијом. </p>
                <p class="add-space-after justify">
                    Трошкови су утврђени Уредбом Владе Републике Србије („Сл. гласник РС“, бр. 8/06), и то: копија стране А4
                    формата износи 3 динара, А3 формата 6 динара, CD 35 динара, дискете 20 динара, DVD 40 динара,
                    аудио-касета – 150 динара, видео-касета 300 динара, претварање једне стране документа из физичког
                    у електронски облик – 30 динара.
                </p>
                <p class="add-space-after justify">
                    Износ укупних трошкова израде копије документа по вашем захтеву износи 
                    <u> <xsl:value-of select="/Obavestenje/Sadrzaj/Paragraf/Iznos_troskova"></xsl:value-of> </u>
                    динара и уплаћује се на жиро-рачун Буџета Републике Србије бр. 840-742328-843-30, 
                    с позивом на број 97 – ознака шифре
                    општине/града где се налази орган власти (из Правилника о условима и начину вођења рачуна – 
                    „Сл. гласник РС“, 20/07... 40/10). 
                </p>
                
                <p> Достављено: </p>
                <ol>
                    <xsl:if test="/Obavestenje/Sadrzaj/Dostavljeno/@Selected='1'">
                        <b>
                            <li> Именованом  </li>
                        </b>
                        <li> Архиви </li>
                    </xsl:if> 
                    <xsl:if test="/Obavestenje/Sadrzaj/Dostavljeno/@Selected='2'">
                        <li> Именованом  </li>
                        <b>
                            <li> Архиви </li>
                        </b>
                    </xsl:if> 
                </ol> 
                
                <div class="right">
                    <p> ________________________________ </p>
                    <p> (потпис овлашћеног лица, односно руководиоца органа) </p>
                </div>
                
            </body>
        </html>  
    </xsl:template>
    
</xsl:stylesheet>