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
                    ЖАЛБА  ПРОТИВ  ОДЛУКЕ ОРГАНА  ВЛАСТИ КОЈОМ ЈЕ <br></br>
                    <u> ОДБИЈЕН ИЛИ ОДБАЧЕН ЗАХТЕВ </u> ЗА ПРИСТУП ИНФОРМАЦИЈИ 
                </h2>
                
                <p> <b> Повереникy за информације од јавног значаја и заштиту података о личности </b> </p>
                <p class="add-space-after"> Адреса за пошту:  Београд, Булевар краља Александрa бр. 15 </p>
                
                <h1 class="center"> Ж А Л Б А </h1>
                
                <p class="center dotted">
                    <xsl:value-of select="/zalba_na_odluku/zalba/zalilac/ime"></xsl:value-of>,
                    <xsl:value-of select="/zalba_na_odluku/zalba/zalilac/prezime"></xsl:value-of>
                    <xsl:value-of select="/zalba_na_odluku/zalba/zalilac/adresa/grad"></xsl:value-of>,
                    <xsl:value-of select="/zalba_na_odluku/zalba/zalilac/adresa/ulica"></xsl:value-of>,
                    <xsl:value-of select="/zalba_na_odluku/zalba/zalilac/adresa/broj"></xsl:value-of>,
                    <xsl:value-of select="/zalba_na_odluku/zalba/zalilac/sediste"></xsl:value-of>
                </p>
                
                
                <p class="center"> против решења-закључка  </p>
                <p class="dotted justify"> 
                    ( <xsl:value-of select="/zalba_na_odluku/zalba/naziv_organa"></xsl:value-of>  )
                </p>
                <p class="center add-space-after"> ( назив органа који је донео одлуку) </p>
                <p class="add-space-after"> 
                    Број
                    <xsl:value-of select="/zalba_na_odluku/zalba/broj_zahteva"></xsl:value-of>
                    од 
                    <xsl:value-of select="/zalba_na_odluku/zalba/godina"></xsl:value-of>
                    године. 
                </p>
                
                <div class="justify add-space-after ">
                    <p class="indented">  
                        Наведеном одлуком органа власти (решењем, закључком, обавештењем у писаној форми са елементима одлуке) ,
                        супротно закону, одбијен-одбачен је мој захтев који сам поднео/ла-упутио/ла дана 
                        <u>
                            <xsl:value-of select="/zalba_na_odluku/zalba/sadrzaj/datum"></xsl:value-of>
                        </u>
                        године и тако ми ускраћено-онемогућено остваривање уставног и законског права на слободан приступ 
                        информацијама од јавног значаја. Oдлуку побијам у целости, односно у делу којим
                        <u>
                            <xsl:value-of select="/zalba_na_odluku/zalba/sadrzaj/deo_odluke"></xsl:value-of>
                        </u> 
                        јер није заснована на Закону о слободном приступу информацијама од јавног значаја.
                    </p>
                    <p class="indented">
                        На основу изнетих разлога, предлажем да Повереник уважи моју жалбу,  
                        поништи одлука првостепеног органа и омогући ми приступ траженој/им  информацији/ма.
                    </p>
                    <p class="indented">
                        Жалбу подносим благовремено, у законском року утврђеном у члану 22. ст. 1.
                        Закона о слободном приступу информацијама од јавног значаја.
                    </p>
                </div>
                
                <div class="half">
                    У <u> <xsl:value-of select="/zalba_na_odluku/zalba/vreme_i_mesto/grad"></xsl:value-of> </u>
                    дана <u> <xsl:value-of select="/zalba_na_odluku/zalba/vreme_i_mesto/datum"></xsl:value-of>  </u>
                    године
                    
                </div>
                
                
                <div class="right half">
                    <p class="dotted"> 
                        <xsl:value-of select="/zalba_na_odluku/zalba/podnosilac/ime"></xsl:value-of> 
                        <xsl:value-of select="/zalba_na_odluku/zalba/podnosilac/prezime"></xsl:value-of>
                    </p>
                    <p> Подносилац жалбе / Име и презиме </p>
                    <p class="dotted"> 
                        <xsl:value-of select="/zalba_na_odluku/zalba/podnosilac/adresa/grad"></xsl:value-of> 
                        <xsl:value-of select="/zalba_na_odluku/zalba/podnosilac/adresa/ulica"></xsl:value-of> 
                        <xsl:value-of select="/zalba_na_odluku/zalba/podnosilac/adresa/broj"></xsl:value-of>
                    </p>
                    <p> адреса </p>
                    <p class="dotted"> 
                        <xsl:value-of select="/zalba_na_odluku/zalba/podnosilac/kontakt_podaci"></xsl:value-of> 
                    </p>
                    <p> други подаци за контакт </p>
                    <p> ................................... </p>
                    <p> потпис </p>
                </div>
                
                <p>
                    <b> Напомена: </b>
                </p>
                <div class="justify">
                    <ul>
                        <li>
                            У жалби се мора навести одлука која се побија (решење, закључак, обавештење), назив органа који је 
                            одлуку донео, као и број и датум одлуке. Довољно је да жалилац наведе у жалби у ком погледу је незадовољан одлуком,
                            с тим да жалбу не мора посебно образложити. Ако жалбу изјављује на овом обрасцу, додатно образложење може  посебно приложити. 
                        </li>
                        <li>
                            Уз жалбу обавезно приложити копију поднетог захтева и доказ о његовој предаји-упућивању органу
                            као и копију одлуке органа која се оспорава жалбом.
                        </li>
                    </ul>
                </div>
                
            </body>
        </html>  
    </xsl:template>
    
</xsl:stylesheet>