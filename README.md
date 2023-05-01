# PIISW_projekt
## Elektroniczny bilet miejski (Treść zadania)
**Użytkownik** uzyskuje możliwość <ins>rejestracji w serwisie</ins> oraz <ins>wygenerowanie wirtualnego biletu</ins> umożliwiającego 
korzystanie z systemu transportu zbiorowego. **System** umożliwia <ins>weryfikację sprawdzanych biletów<ins>.

**Pasażer** może <ins>założyć sobie konto</ins> w systemie. W ramach konta możliwe jest przeglądanie dostępnej oferty biletowe 
(_bilety czasowe, jednorazowe, okresowe; ulgowe i normalne_). **Pasażer** może wybrać dowolny bilet, wybrać jego ważność 
(w przypadku biletów czasowych i okresowych) oraz <ins>dokonać zakupu</ins>. Po zakupie, bilet pojawia się w zakładce "moje bilety". 
Każdy _bilet posiada unikalnie wygenerowany kod_, umożliwiający jego walidację.

**System** powinien posiadać prosty interfejs REST pozwalający na zintegrowanie z systemem kasowników (każdy bilet jednorazowy 
i czasowy wymaga skasowania, _bilet nieskasowany jest nieważny_).

**Bileter** posiada możliwość <ins>sprawdzenia ważności biletu</ins> - w tym celu konieczne jest wprowadzenie _kodu biletu oraz 
identyfikatora pojazu_. Bilet może być ważny lub nieważny. Bilet jest ważny tylko wtedy, gdy:

- W przypadku biletu _okresowego_ - data kontroli zawiera się w okresie ważności biletu.
- W przypadku biletu _jednorazowego_ - bilet został skasowany w pojeździe, w którym przeprowadzana jest kontrola.
- W przypadku biletu _czasowego_ - nie upłynął czas ważności biletu od momentu skasowania biletu.

----

System powinien obsługiwać dwie klasy użytkowników:
### Pasażer
Funkcja wymaga <ins>zalogowania się</ins> do systemu. Kupujący może <ins>przeglądać dostępną ofertę biletową</ins>, 
<ins>kupić bilet</ins> oraz <ins>podglądać zakupione bilety</ins> wraz z historią transakcji.

### Bileter
Funkcja wymaga <ins>zalogowania się</ins> do systemu. Bileter może <ins>sprawdzać ważność kodu biletu</ins>.
