<h1>SuperMarketApp  -- Googledagopdracht :)</h1>
<h4>Deze opdracht is geheel vrijblijvend. Mocht je mee willen doen aan deze opdracht, dan zou dat het leukste zijn als we teams maken! De meeste IDE's hebben wel collaboration extensions zodat je samen (op afstand) kan pair-programmen
<ul>
  <li>Clone de repo</li>
  <li>Maak een branch per opdracht</li>
  <li>Je kan bijvoorbeeld je branch zo noemen: {teamnaam}/OpdrachtX</li>
  <li>Ben je klaar met een opdracht? Open een PR voor je branch. NIET MERGEN AUB!</li>
  <li>Volgende opdracht? Trek een branch van je vorige branch en ga daar mee verder</li> 
  </ul>
  </h4> 

<h2>Kassa- en voorraadsysteem</h2>
In deze opdracht probeer je een (fractie) van een IT systeem van een supermarkt te maken. In de eerste opdrachten zal het vooral gaan om het maken van een kassasysteem. Klant komt met een winkelwagen met stapels boodschappen bij de kassa en gaat afrekenen. Verderop wordt er ingegaan op het maken van voorraden, en deze bij te werken als iemand bij de kassa is geweest. Later ga je connectie maken met de LijpeVoorraadServer om verzoeken te sturen om de voorraden in de supermarkt aan te vullen. Als laatste ga je zelf een api bouwen om een bericht te ontvangen dat de gestuurde voorraden binnen zijn, en deze te laten verwerken in de voorraden van de winkel.
Maak natuurlijk (unit) tests om te kijken je code werkt! 

<h3>Opdracht 1 -- Kassasysteem</h3>
Onderstaand staan een aantal testproducten. Maak de applicatie zo dat deze producten in een winkelwagentje gezet kunnen worden, die vervolgens bij een kassa kan komen. Bij de kassa worden de producten bij elkaar opgeteld en wordt een prijs bepaald. Nadat alles is opgeteld, wordt er een bonnetje geprint (totaalbedrag is voldoende).
Afgekeken van de wat bekendere supermarkten, kunnen producten in de bonus zijn. Bonusaanbiedingen leveren 20% korting op per product. 
Ook afgekeken van wat bekendere supermarkten, kunnen producten bijna over datum zijn. Deze producten krijgen een nog forsere korting, namelijk 35%. Echter kan deze korting NIET samen met de bonuskorting
Toon aan dat deze kortingen werken met tests!

Producten (naam, barcode, prijs):
<ul>
  <li>Kaas, 156734,  4.99</li>
  <li>Ham, 579843, 1.49</li>
  <li>Melk, 378941, 0.99</li>
  <li>Pizza, 739214, 4.59</li>
  <li>Bier, 798234, 11,99</li>
</ul>
  
<h3>Opdracht 2 -- Voorraden bijhouden</h3>
Nu gaan we de voorraden bijhouden als er producten bij de kassa worden afgerekend
<ul>
  <li>Maak een database aan</li>
  <li>Maak een tabel (of wat je ook wil gebruiken) met de eerdere productvoorbeelden</li>
  <li>OPTIONEEL: Maak een referentietabel aan (obv barcodes)</li>
  <li>Maak een tabel (of breidt het huidige tabel verder uit) met aantallen producten. Voeg van alles maar voor het gemak 100 toe</li>
  <li>Maak nu logica, die productaantallen bijwerkt indien deze afgerekend worden bij de kassa</li>
</ul>
Aantal producten mag niet kleiner dan 0 zijn
Toon je code aan met tests

<h3>Opdracht 3 -- Verzoek doen om voorraaden aan te vullen</h3>
In deze opdracht, ga je contact maken met de super LijpeVoorraadServer (LVS)! De LVS heeft een RESTful API waar je berichten naar toe kan schieten. In dit bericht stuur je simpelweg de barcode, en het aantal producten dat je wil hebben.
<ul>
  <li>Zet een connector op die HTTP requests kan uitvoeren</li>
  <li>Maak een berichtenmodel op</li>
  <li>Aan het einde van de dag zijn er 5 klanten geweest met een stapel producten. Het is tijd voor de call naar LVS. Zorg dat LVS een bericht krijgt dat het verschil van de aantal producten dat je wil hebben (100), en de huidige voorraad</li>
</ul>

<h3>Opdracht 4 -- Voorraden worden bijgevuld</h3>
Nadat gister LVS het bericht gehad heeft om voorraden bij te vullen, staan ze vandaag op de stoep van de supermarkt om de goederen te leveren. 
Maak nu zelf een API die berichten kan ontvangen om de voorraad bij te werken. 
<ul>
  <li>Zet een project/solution/file op zodat je iets van web hosting (lokaal) kan doen</li>
  <li>Bedenk hoe je berichten wil ontvangen. Wil je een body? Queryparameters?</li>
  <li>Maak logica die de inkomende berichten ontvangt, en de voorraden tabel bijwerkt</li>
  <li>Toon dit aan met tests :) </li>

<h3>Optionele opdrachten</h3>
<ul>
  <li>Voeg een kolom ExpiryDate toe aan de producten. Je kan uitgaan dat de 100 producten in batches komen. Zorg er nu voor dat producten die nog 1 dag houdbaar zijn, automatisch de houdbaarheidsbonus krijgen</li>
  <li>Er is een foutje gemaakt in het voorraadsysteem! Een klant komt bij de kassa, rekent af, en de kassa geeft een error! Wat blijkt: Bier was het laatste product maar het voorraadsysteem dacht dat het al op was! Maak logica om dit soort fouten af te handelen </li>
</ul>
