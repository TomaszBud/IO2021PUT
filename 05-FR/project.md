# System aukcyjny

## Wprowadzenie

Specyfikacja wymagań funkcjonalnych w ramach informatyzacji procesu sprzedaży produktów w oparciu o mechanizm aukcyjny. 

## Procesy biznesowe

---
<a id="bc1"></a>
### BC1: Sprzedaż aukcyjna 

**Aktorzy:** [Sprzedający](#ac1), [Kupujący](#ac2)

**Opis:** Proces biznesowy opisujący sprzedaż za pomocą mechanizmu aukcyjnego. |

**Scenariusz główny:**
1. [Sprzedający](#ac1) wystawia produkt na aukcję. ([UC1](#uc1) wystawienie produktu na aukcję.)
2. [Kupujący](#ac2) oferuje([UC3](#uc3)) kwotę za produkt wyższą od aktualnie najwyższej oferty. ([BR1](#br1) złożenie oferty)
3. [Kupujący](#ac2) wygrywa aukcję ([BR2](#br2) rozstrzygnięcie aukcji.)
4. [Kupujący](#ac2) przekazuje należność([UC2](#uc2)) [Sprzedając](#ac1)emu.
5. [Sprzedający](#ac1) przekazuje produkt([UC2](#uc2)) [Kupując](#ac2)emu.

**Scenariusze alternatywne:** 

2.A. Oferta Kupującego została przebita, a [Kupujący](#ac2) pragnie przebić aktualnie najwyższą ofertę.
* 2.A.1. Przejdź do kroku 2.

3.A. Czas aukcji upłynął i [Kupujący](#ac2) przegrał aukcję. ([BR2](#br2))
* 3.A.1. Koniec przypadku użycia.

---

## Aktorzy

<a id="ac1"></a>
### AC1: Sprzedający

Osoba oferująca towar na aukcji.

<a id="ac2"></a>
### AC2: Kupujący

Osoba chcąca zakupić produkt na aukcji.


## Przypadki użycia poziomu użytkownika

### Aktorzy i ich cele

[Sprzedający](#ac1):
* [UC1](#uc1): Wystawienie produktu na aukcję
* [UC2](#uc2): Przekazanie produktu [Kupując](#ac2)emu

[Kupujący](#ac2)
*  [UC3](#uc3): przebicie oferty
*  [UC2](#uc2): Odbiór produktu od [Sprzedając](#ac1)ego

---
<a id="uc1"></a>
### UC1: Wystawienie produktu na aukcję

**Aktorzy:** [Sprzedający](#ac1)

**Scenariusz główny:**
1. [Sprzedający](#ac1) zgłasza do systemu chęć wystawienia produktu na aukcję.
2. System prosi o podanie danych produktu i ceny wywoławczej.
3. [Sprzedający](#ac1) podaje dane produktu oraz cenę wywoławczą.
4. System weryfikuje poprawność danych.
5. System informuje o pomyślnym wystawieniu produktu na aukcję.

**Scenariusze alternatywne:** 

4.A. Podano niepoprawne lub niekompletne dane produktu.
* 4.A.1. System informuje o błędnie podanych danych.
* 4.A.2. Przejdź do kroku 2.

---

<a id="uc2"></a>
### UC2: Przekazanie produktu [Kupując](#ac2)emu

**Aktorzy:** [Sprzedający](#ac1), [Kupujący](#ac2), ...

**Scenariusz główny:**
1. [Kupujący](#ac2), w rezultacie [rozstrzygnięci](#br2)a aukcji, wygrywa.
2. [Kupujący](#ac2) przekazuje pieniądze do Systemu.
3. System potwierdza płatność.
4. [Sprzedający](#ac1) przekazuje produkt [Kupując](#ac2)emu.
5. System przekazuje pieniądze [Sprzedając](#ac1)emu.
4. [Kupujący](#ac2) otrzymuje produkt.

**Scenariusze alternatywne:** 

2.A. [Kupujący](#ac2) nie ma zamiaru wpłacać pieniędzy.
* 2.A.1. Przejdź ponownie do punktu 2. [sprzedaż](#bc1)y

4.A [Sprzedający](#ac1) nie ma zamiaru przekazać produktu [Kupując](#ac2)emu.
* 4.A.1. Zwróć pieniądze [Kupując](#ac2)emu.
* 4.A.2. Przejdź ponownie do punktu 2. [sprzedaż](#bc1)y

---

<a id="uc3"></a>
### UC3: Przebicie oferty

**Aktorzy:** [Kupujący](#ac2)

**Scenariusz główny:**
1. [Kupujący](#ac2) [składa](#br1) ofertę wysyłając kwotę do Systemu obsługi.
2. System weryfikuje kwotę i stan konta [Kupując](#ac2)ego.
3. System informuje o pomyślnym przebiciu kwoty.
4. System prezentuje cenę za produkt.


**Scenariusze alternatywne:** 

2.A. Kwota jest niższa od aktualnie najwyższej.
* 2.A.1. System informuje [Kupując](#ac2)ego o zaistniałej sytuacji - kwota pozostaje niezmieniona.

2.B Niewystarczające środki na koncie [Kupując](#ac2)ego.
* 2.B.1 System informuje [Kupując](#ac2)ego o zaistniałej sytuacji. 

---
## Obiekty biznesowe (inaczej obiekty dziedzinowe lub informatycjne)

### BO1: Aukcja

Aukcja jest formą zawierania transakcji kupna-sprzedaży, w której Sprzedający określa cenę wywoławczą produktu, natomiast Kupujący mogą oferować własną ofertę zakupu każdorazowo proponując kwotę wyższą od aktualnie oferowanej kwoty. Aukcja kończy się po upływie określonego czasu. Jeśli złożona została co najmniej jedna oferta zakupy produkt nabywa ten Kupujący, który zaproponował najwyższą kwotę. 

### BO2: Produkt

Fizyczny lub cyfrowy obiekt, który ma zostać sprzedany w ramach aukcji.

### BO3: Kwota

Pieniądze oferowane za produkt w wyniku licytacji. Minimalną kwotą jest cena wywoławcza.

## Reguły biznesowe

<a id="br1"></a>
### BR1: Złożenie oferty

Złożenie oferty wymaga zaproponowania kwoty wyższej niż aktualnie oferowana o minimum 1,00 PLN.


<a id="br2"></a>
### BR2: Rozstrzygnięcie aukcji

Aukcję wygrywa ten z [Kupujący](#ac2)ch, który w momencie jej zakończenia (upłynięcia czasu) złożył najwyższą ofertę.

## Macierz CRUDL


| Przypadek użycia                                  | Aukcja | Produkt | Kwota      |
| ------------------------------------------------- | ------ | ------- | ---------- |
| UC1: Wystawienie produktu na aukcję               |    C   |    C    |      C     |
| UC3: Przebicie oferty                             |        |         |      U     |
| UC2: Przekazanie produktu [Kupując](#ac2)emu      |    D   |    D    |      D     |


