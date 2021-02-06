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
                    margin-bottom: 30px;
                    }
                    
                    .half{
                    width: 40%;
                    }
                </style>
            </head>
            
            <body>
                <p> 
                    <u>
                        <xsl:value-of select="/zahtev/info_organa/naziv"></xsl:value-of>, 
                        <xsl:value-of select="/zahtev/info_organa/sediste"></xsl:value-of>
                    </u>
                </p>
                <small class="add-space-after"> (назив и седиште органа коме се захтев упућује) </small>
                
                <h1> З А Х Т Е В </h1>
                <h2 class="add-space-after"> за приступ информацији од јавног значаја </h2>
                
                <p class="indented add-space-after">
                    На основу члана 15. ст. 1. Закона о слободном приступу информацијама од
                    јавног значаја („Службени гласник РС“, бр. 120/04, 54/07, 104/09 и 36/10),
                    од горе наведеног органа захтевам:*
                </p>
                
                <ol>
                    <xsl:for-each select="/zahtev/opis_zahteva/tipovi_zahteva/tip_zahteva">
                        <xsl:choose>
                            <xsl:when test="@rb = '1'">
                                <xsl:choose>
                                    <xsl:when test="@selektovan = 'true'">
                                        <li>
                                            <strong><b> обавештење да ли поседује тражену информацију; </b></strong>  
                                        </li>
                                    </xsl:when>
                                </xsl:choose>
                                <xsl:choose>
                                    <xsl:when test="@selektovan = 'false'">
                                        <li>
                                            обавештење да ли поседује тражену информацију;
                                        </li>
                                    </xsl:when>
                                </xsl:choose>
                            </xsl:when>
                        </xsl:choose>
                        
                        <xsl:choose>
                            <xsl:when test="@rb = '2'">
                                <xsl:choose>
                                    <xsl:when test="@selektovan = 'true'">
                                        <li>
                                            <strong><b> увид у документ који садржи тражену информацију; </b></strong>  
                                        </li>
                                    </xsl:when>
                                </xsl:choose>
                                <xsl:choose>
                                    <xsl:when test="@selektovan = 'false'">
                                        <li>
                                            увид у документ који садржи тражену информацију;
                                        </li>
                                    </xsl:when>
                                </xsl:choose>
                            </xsl:when>
                        </xsl:choose>
                        
                        <xsl:choose>
                            <xsl:when test="@rb = '3'">
                                <xsl:choose>
                                    <xsl:when test="@selektovan = 'true'">
                                        <li>
                                            <strong><b> копију документа који садржи тражену информацију; </b></strong>  
                                        </li>
                                    </xsl:when>
                                </xsl:choose>
                                <xsl:choose>
                                    <xsl:when test="@selektovan = 'false'">
                                        <li>
                                            копију документа који садржи тражену информацију;
                                        </li>
                                    </xsl:when>
                                </xsl:choose>
                            </xsl:when>
                        </xsl:choose>
                        
                        <xsl:choose>
                            <xsl:when test="@rb = '4'">
                                <xsl:choose>
                                    <xsl:when test="@selektovan = 'true'">
                                        <li>
                                            <strong><b> достављање копије документа који садржи тражену информацију:** </b></strong>  
                                        </li>
                                    </xsl:when>
                                </xsl:choose>
                                <xsl:choose>
                                    <xsl:when test="@selektovan = 'false'">
                                        <li>
                                            достављање копије документа који садржи тражену информацију:**
                                        </li>
                                    </xsl:when>
                                </xsl:choose>
                            </xsl:when>
                        </xsl:choose>
                    </xsl:for-each>
                </ol>
                
                <ul>
                    <xsl:for-each select="/zahtev/opis_zahteva/tipovi_zahteva/tip_zahteva/nacini_slanja/nacin_slanja">
                        <xsl:choose>
                            <xsl:when test="@rb = '1'">
                                <xsl:choose>
                                    <xsl:when test="@selektovan = 'true'">
                                        <li>
                                            <strong><b> поштом </b></strong>  
                                        </li>
                                    </xsl:when>
                                </xsl:choose>
                                <xsl:choose>
                                    <xsl:when test="@selektovan = 'false'">
                                        <li>
                                            поштом
                                        </li>
                                    </xsl:when>
                                </xsl:choose>
                            </xsl:when>
                        </xsl:choose>
                        
                        <xsl:choose>
                            <xsl:when test="@rb = '2'">
                                <xsl:choose>
                                    <xsl:when test="@selektovan = 'true'">
                                        <li>
                                            <strong><b> електронском поштом </b></strong>  
                                        </li>
                                    </xsl:when>
                                </xsl:choose>
                                <xsl:choose>
                                    <xsl:when test="@selektovan = 'false'">
                                        <li>
                                            електронском поштом
                                        </li>
                                    </xsl:when>
                                </xsl:choose>
                            </xsl:when>
                        </xsl:choose>
                        
                        <xsl:choose>
                            <xsl:when test="@rb = '3'">
                                <xsl:choose>
                                    <xsl:when test="@selektovan = 'true'">
                                        <li>
                                            <strong><b> факсом </b></strong>  
                                        </li>
                                    </xsl:when>
                                </xsl:choose>
                                <xsl:choose>
                                    <xsl:when test="@selektovan = 'false'">
                                        <li>
                                            факсом
                                        </li>
                                    </xsl:when>
                                </xsl:choose>
                            </xsl:when>
                        </xsl:choose>
                        
                        <xsl:choose>
                            <xsl:when test="@rb = '4'">
                                <xsl:choose>
                                    <xsl:when test="@selektovan = 'true'">
                                        <li>
                                            <strong>
                                                <b> 
                                                    на други начин:*** 
                                                    <u> 
                                                        <xsl:value-of select="."></xsl:value-of> 
                                                    </u>
                                                </b>
                                            </strong>  
                                        </li>
                                    </xsl:when>
                                </xsl:choose>
                                <xsl:choose>
                                    <xsl:when test="@selektovan = 'false'">
                                        <li>
                                            на други начин:***
                                        </li>
                                    </xsl:when>
                                </xsl:choose>
                            </xsl:when>
                        </xsl:choose>
                    </xsl:for-each>
                </ul>
                
                <p class="indented">
                    Овај захтев се односи на следеће информације:
                </p>
                <p class="indented">
                    <u>
                        <xsl:value-of select="/zahtev/opis_zahteva/dodatne_informacije/opis_dodatne_informacije"></xsl:value-of>
                    </u>
                </p>
                <small class="add-space-after">
                    (навести што прецизнији опис информације која се тражи као и друге податке
                    који олакшавају проналажење тражене информације)
                </small>
                
                <div class="add-space-after">
                    <span class="half">
                        <p> У <u> <xsl:value-of select="/zahtev/mesto"></xsl:value-of> </u> </p>
                        <p> Datum: <u> <xsl:value-of select="/zahtev/datum"></xsl:value-of> </u> </p>
                    </span>
                    
                    <span class="half">
                        <p> <u> <xsl:value-of select="/zahtev/trazilac/ime_i_prezime"></xsl:value-of> </u> </p>
                        <small> (Тражилац информације/Име и презиме) </small>
                        <p> <u> <xsl:value-of select="/zahtev/trazilac/adresa"></xsl:value-of> </u> </p>
                        <small> (Aдреса) </small>
                        <p> <u> <xsl:value-of select="/zahtev/trazilac/kontakt"></xsl:value-of> </u> </p>
                        <small> (други подаци за контакт) </small>
                    </span>
                </div>
                
                <hr/>
                <p> * У кућици означити која законска права на приступ информацијама желите да остварите. </p>
                <p> ** У кућици означити начин достављања копије докумената. </p>
                <p> *** Када захтевате други начин достављања обавезно уписати који начин достављања захтевате. </p>
                
            </body>
        </html>  
    </xsl:template>
    
</xsl:stylesheet>