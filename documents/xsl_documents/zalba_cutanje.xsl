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
                    
                    .dotted {
                    text-decoration-style: dotted;
                    }
                </style>
            </head>
            
            <body>
                
                <h2 class="center add-space-after">
                    ЖАЛБА КАДА ОРГАН ВЛАСТИ <u> НИЈЕ ПОСТУПИО/ није поступио у целости/ ПО ЗАХТЕВУ </u> ТРАЖИОЦА У ЗАКОНСКОМ  РОКУ  (ЋУТАЊЕ УПРАВЕ)
                </h2>
                
                <p> <b> Повереникy за информације од јавног значаја и заштиту података о личности </b> </p>
                <p class="add-space-after"> Адреса за пошту:  Београд, Булевар краља Александрa бр. 15 </p>

                <p class="justify">
                    У складу са чланом 22. Закона о слободном приступу информацијама од јавног значаја подносим:
                </p>
                <h1 class="center"> Ж А Л Б У </h1>
                <p class="center"> против </p>
                <p class="dotted justify"> 
                    <xsl:value-of select="/Zalba_na_cutanje/Sadrzaj/Naziv_organa"></xsl:value-of>  
                </p>
                <p class="center add-space-after"> ( навести назив органа) </p>
                
                <div class="center add-space-after">
                    <p> због тога што орган власти:  </p>
                    <xsl:if test="/Zalba_na_cutanje/Sadrzaj/Razlozi_zalbe/@Selected='1'">
                        <p> <b> <u> није поступио </u>  / није поступио у целости /  у законском року </b> </p>
                    </xsl:if>
                    <xsl:if test="/Zalba_na_cutanje/Sadrzaj/Razlozi_zalbe/@Selected='2'">
                        <p> <b> није поступио / <u> није поступио у целости </u> /  у законском року </b> </p>
                    </xsl:if>
                    <xsl:if test="/Zalba_na_cutanje/Sadrzaj/Razlozi_zalbe/@Selected='3'">
                        <p> <b> није поступио / није поступио у целости /  <u> у законском року </u> </b> </p>
                    </xsl:if>
                    <p> (подвући  због чега се изјављује жалба) </p>
                </div>
                
                <p class="justify">
                    по мом захтеву  за слободан приступ информацијама од јавног значаја који сам поднео  том органу  дана
                    <u> <xsl:value-of select="/Zalba_na_cutanje/Sadrzaj/Datum_podnosenja_zahteva"></xsl:value-of> </u>
                    године, а којим сам тражио/ла да ми се у складу са Законом о слободном приступу информацијама од јавног
                    значаја омогући увид- копија документа који садржи информације  о /у вези са :
                </p>
                <p class="dotted justify">
                    <xsl:value-of select="/Zalba_na_cutanje/Sadrzaj/Podaci_o_zahtevu"></xsl:value-of>
                </p>
                <p class="center add-space-after"> (навести податке о захтеву и информацији/ама) </p>
                
                <p class="indented justify">
                    На основу изнетог, предлажем да Повереник уважи моју жалбу и омогући ми приступ траженој/им  информацији/ма.
                </p>
                <p class="indented justify">
                    Као доказ , уз жалбу достављам копију захтева са доказом о предаји органу власти.
                </p>
                <p class="indented justify add-space-after">
                    <b>Напомена:</b> Код жалбе  због непоступању по захтеву у целости, треба приложити и добијени одговор органа власти.
                </p>
                
                <div class="right">
                    <p class="dotted"> 
                        <xsl:value-of select="/Zalba_na_cutanje/Podnosilac_zalbe/Ime"></xsl:value-of> 
                        <xsl:value-of select="/Zalba_na_cutanje/Podnosilac_zalbe/Prezime"></xsl:value-of>
                    </p>
                    <p> Подносилац жалбе / Име и презиме </p>
                    <p> ................................... </p>
                    <p> потпис </p>
                    <p class="dotted"> 
                        <xsl:value-of select="/Zalba_na_cutanje/Podnosilac_zalbe/Adresa"></xsl:value-of> 
                    </p>
                    <p> адреса </p>
                    <p class="dotted"> 
                        <xsl:value-of select="/Zalba_na_cutanje/Podnosilac_zalbe/Kontakt_podaci"></xsl:value-of> 
                    </p>
                    <p> други подаци за контакт </p>
                    <p> ................................... </p>
                    <p> потпис </p>
                </div>
                
                <p>
                    У <u> <xsl:value-of select="/Zalba_na_cutanje/Vreme_i_mesto/Mesto"></xsl:value-of> </u>
                    , дана <u> <xsl:value-of select="/Zalba_na_cutanje/Vreme_i_mesto/Datum"></xsl:value-of> </u>
                    године
                </p>
                
            </body>
        </html>  
    </xsl:template>
    
</xsl:stylesheet>