<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet 
    xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
    xmlns:fo="http://www.w3.org/1999/XSL/Format"
    xmlns:ns2="http://www.ftn.uns.ac.rs/zalba-na-cutanje"
    xmlns:xs="http://www.w3.org/2001/XMLSchema" version="2.0">
    <xsl:template match="/">
        <fo:root>
            <fo:layout-master-set>
                <fo:simple-page-master
                    master-name="zalba-cutanje-page">
                    <fo:region-body margin-top="0.75in"
                        margin-bottom="0.75in" margin-left="80pt" margin-right="80pt" />
                </fo:simple-page-master>
            </fo:layout-master-set>
            
            <fo:page-sequence master-reference="zalba-cutanje-page">
                <fo:flow flow-name="xsl-region-body">
                    
                    <fo:block font-family="Times New Roman" font-size="10pt"
                        font-weight="bold" text-align="center" margin-top="48pt">
                        ЖАЛБА КАДА ОРГАН ВЛАСТИ
                        <fo:inline  font-family="Times New Roman" font-size="10pt"
                            font-weight="bold" text-align="center" margin-top="48pt" text-decoration="underline">
                            НИЈЕ ПОСТУПИО/ није поступио у целости/ ПО ЗАХТЕВУ
                        </fo:inline>
                        ТРАЖИОЦА У ЗАКОНСКОМ  РОКУ  (ЋУТАЊЕ УПРАВЕ)
                    </fo:block>

                    <fo:block font-family="Times New Roman" font-size="12pt"
                        text-align="left" margin-top="28pt" font-weight="bold">
                        Повереникy за информације од јавног значаја и заштиту података о личности 
                    </fo:block>
                    <fo:block font-family="Times New Roman" font-size="11pt" text-align="left">
                        Адреса за пошту:  Београд, Булевар краља Александрa бр. 15 
                    </fo:block>
                    
                    <fo:block font-family="Times New Roman" font-size="11pt"
                        text-align="justify">
                        У складу са чланом 22. Закона о слободном приступу информацијама од јавног значаја подносим:
                    </fo:block>
                    
                    <fo:block font-family="Times New Roman" font-size="11pt"
                        text-align="center" margin-top="12pt" font-weight="bold">
                        Ж А Л Б У
                    </fo:block>
                    <fo:block font-family="Times New Roman" font-size="11pt" text-align="center">
                        против
                    </fo:block>
                    <fo:block font-family="Times New Roman" width="60%"
                        margin-top="11pt" text-align="center" border-bottom-style="dotted">
                        <xsl:value-of select="/ns2:Zalba_na_cutanje/ns2:Sadrzaj/ns2:Naziv_organa"></xsl:value-of>
                    </fo:block>
                    <fo:block font-family="Times New Roman" font-size="11pt"
                        text-align="center" font-weight="bold">
                        ( навести назив органа)
                    </fo:block>
                    
                    <fo:block font-family="Times New Roman" font-size="11pt"
                        text-align="center" margin-top="15pt">
                        због тога што орган власти: 
                    </fo:block>
                    
                    <xsl:if test="/ns2:Zalba_na_cutanje/ns2:Sadrzaj/ns2:Razlozi_zalbe/@Selected='1'">
                        <fo:block font-family="Times New Roman" font-size="11pt" text-align="center" margin-top="15pt">
                            <fo:inline  font-family="Times New Roman" font-size="10pt" text-align="center" text-decoration="underline">
                                није поступио
                            </fo:inline>  
                            / није поступио у целости /  у законском року
                        </fo:block>
                    </xsl:if>
                    <xsl:if test="/ns2:Zalba_na_cutanje/ns2:Sadrzaj/ns2:Razlozi_zalbe/@Selected='2'">
                        <fo:block font-family="Times New Roman" font-size="11pt" text-align="center" margin-top="15pt">
                            није поступио /
                            <fo:inline  font-family="Times New Roman" font-size="10pt" text-align="center" text-decoration="underline">
                                није поступио у целости
                            </fo:inline>  
                            /  у законском року
                        </fo:block>
                    </xsl:if>
                    <xsl:if test="/ns2:Zalba_na_cutanje/ns2:Sadrzaj/ns2:Razlozi_zalbe/@Selected='3'">
                        <fo:block font-family="Times New Roman" font-size="11pt" text-align="center" margin-top="15pt">
                            није поступио / није поступио у целости /
                            <fo:inline  font-family="Times New Roman" font-size="10pt" text-align="center" text-decoration="underline">
                                у законском року
                            </fo:inline>  
                        </fo:block>
                    </xsl:if>
                    
                    <fo:block font-family="Times New Roman" font-size="11pt"
                        text-align="center">
                        (подвући  због чега се изјављује жалба)
                    </fo:block>
                    
                    <fo:block font-family="Times New Roman" font-size="11pt"
                        text-align="justify" margin-top="10pt">
                        по мом захтеву  за слободан приступ информацијама од јавног значаја који сам поднео  том органу  дана
                        <fo:inline border-bottom-style="dotted">
                            <xsl:value-of select="/ns2:Zalba_na_cutanje/ns2:Sadrzaj/ns2:Datum_podnosenja_zahteva"></xsl:value-of>
                        </fo:inline>
                        године, а којим сам тражио/ла да ми се у складу са Законом о слободном приступу информацијама од јавног 
                        значаја омогући увид- копија документа који садржи информације  о /у вези са :
                    </fo:block>
                    <fo:block font-family="Times New Roman" width="60%"
                        margin-top="11pt" text-align="center" border-bottom-style="dotted">
                        <xsl:value-of select="/ns2:Zalba_na_cutanje/ns2:Sadrzaj/ns2:Podaci_o_zahtevu"></xsl:value-of>
                    </fo:block>
                    <fo:block font-family="Times New Roman" font-size="11pt"
                        text-align="center">
                        (навести податке о захтеву и информацији/ама)
                    </fo:block>
                    
                    <fo:block font-family="Times New Roman" font-size="11pt"
                        text-align="justify" margin-top="28pt" text-indent="40px">
                        На основу изнетог, предлажем да Повереник уважи моју жалбу и омогући ми приступ траженој/им  информацији/ма.
                    </fo:block>
                    <fo:block font-family="Times New Roman" font-size="11pt"
                        text-align="justify" text-indent="40px">
                        Као доказ , уз жалбу достављам копију захтева са доказом о предаји органу власти.
                    </fo:block>
                    <fo:block font-family="Times New Roman" font-size="11pt" text-align="justify" text-indent="40px">
                        <fo:inline font-family="Times New Roman" font-size="11pt" text-align="justify" font-weight="bold">
                            Напомена:
                        </fo:inline>
                        Код жалбе због непоступању по захтеву у целости, треба приложити и добијени одговор органа власти.
                    </fo:block>
                    
                    <fo:block font-family="Times New Roman" font-size="11pt" text-align="right" margin-top="10pt" margin-bottom="-7pt">
                        <xsl:value-of select="/ns2:Zalba_na_cutanje/ns2:Podnosilac_zalbe/ns2:Ime"></xsl:value-of> 
                        <xsl:value-of select="/ns2:Zalba_na_cutanje/ns2:Podnosilac_zalbe/ns2:Prezime"></xsl:value-of>
                    </fo:block>
                    <fo:block font-family="Times New Roman" font-size="11pt" text-align="right" margin-bottom="3pt" >
                        <fo:block font-size="11pt" text-align="right">.........................................................................</fo:block>
                        Подносилац жалбе / Име и презиме
                    </fo:block>
                    <fo:block font-family="Times New Roman" font-size="11pt" text-align="right" margin-top="3pt" >
                        <fo:block font-size="11pt" text-align="right">.........................................................................</fo:block>
                        потпис
                    </fo:block>
                    <fo:block font-family="Times New Roman" font-size="11pt" text-align="right" margin-top="3pt"  margin-bottom="-7pt">
                        <xsl:value-of select="/ns2:Zalba_na_cutanje/ns2:Podnosilac_zalbe/ns2:Adresa"></xsl:value-of>
                    </fo:block>
                    <fo:block font-family="Times New Roman" font-size="11pt" text-align="right" >
                        <fo:block font-size="11pt" text-align="right">.........................................................................</fo:block>
                        адреса
                    </fo:block>
                    <fo:block font-family="Times New Roman" font-size="11pt" text-align="right" margin-top="3pt"  margin-bottom="-7pt">
                        <xsl:value-of select="/ns2:Zalba_na_cutanje/ns2:Podnosilac_zalbe/ns2:Kontakt_podaci"></xsl:value-of>
                    </fo:block>
                    <fo:block font-family="Times New Roman" font-size="11pt" text-align="right" >
                        <fo:block font-size="11pt" text-align="right">.........................................................................</fo:block>
                        други подаци за контакт
                    </fo:block>
                    <fo:block text-align="left" margin-top="10pt" font-family="Times New Roman" font-size="11pt">
                        У 
                        <fo:inline  text-decoration="underline" >
                            <xsl:value-of select="/ns2:Zalba_na_cutanje/ns2:Vreme_i_mesto/ns2:Mesto"></xsl:value-of>
                        </fo:inline>, 
                        <fo:inline text-decoration="underline">
                            <xsl:value-of select="/ns2:Zalba_na_cutanje/ns2:Vreme_i_mesto/ns2:Datum"></xsl:value-of>
                        </fo:inline> године.
                    </fo:block>
                </fo:flow>
            </fo:page-sequence>
        </fo:root>
    </xsl:template>
</xsl:stylesheet>