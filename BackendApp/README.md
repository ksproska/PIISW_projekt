# Sending request
For dev profile basic GET request:
```bash
curl -v -u 'admin:admin' http://localhost:8080
```
```bash
curl -X POST -H "Content-Type: application/json" -d '{"concession":"NORMAL", "price":1.50}' -v http://localhost:8080/offers
curl -X POST -H "Content-Type: application/json" -d '{"concession":"REDUCED_FARE", "price":1.50}' -v http://localhost:8080/offers
```

# Ticket offer - script to add instances to database
```postgresql
INSERT INTO offer(id, price, dtype, concession) VALUES (101, 4.60, 'OfferSingleTicket', 'NORMAL');
INSERT INTO offer(id, price, dtype, concession) VALUES (102, 2.30, 'OfferSingleTicket', 'REDUCED_FARE');

INSERT INTO offer(id, price, dtype, concession, validity_length_in_minutes) VALUES (103, 3.20, 'OfferCommuterPass', 'NORMAL', 0);
INSERT INTO offer(id, price, dtype, concession, validity_length_in_minutes) VALUES (104, 1.60, 'OfferCommuterPass', 'REDUCED_FARE', 0);
INSERT INTO offer(id, price, dtype, concession, validity_length_in_minutes) VALUES (105, 4.00, 'OfferCommuterPass', 'NORMAL', 1);
INSERT INTO offer(id, price, dtype, concession, validity_length_in_minutes) VALUES (106, 2.00, 'OfferCommuterPass', 'REDUCED_FARE', 1);
INSERT INTO offer(id, price, dtype, concession, validity_length_in_minutes) VALUES (107, 5.20, 'OfferCommuterPass', 'NORMAL', 2);
INSERT INTO offer(id, price, dtype, concession, validity_length_in_minutes) VALUES (108, 2.60, 'OfferCommuterPass', 'REDUCED_FARE', 2);
INSERT INTO offer(id, price, dtype, concession, validity_length_in_minutes) VALUES (109, 15.00, 'OfferCommuterPass', 'NORMAL', 3);
INSERT INTO offer(id, price, dtype, concession, validity_length_in_minutes) VALUES (110, 7.50, 'OfferCommuterPass', 'REDUCED_FARE', 3);

INSERT INTO offer(id, price, dtype, concession, validity_length_in_days) VALUES (111, 38, 'OfferSeasonTicket', 'NORMAL', 0);
INSERT INTO offer(id, price, dtype, concession, validity_length_in_days) VALUES (112, 19, 'OfferSeasonTicket', 'REDUCED_FARE', 0);
INSERT INTO offer(id, price, dtype, concession, validity_length_in_days) VALUES (113, 74, 'OfferSeasonTicket', 'NORMAL', 1);
INSERT INTO offer(id, price, dtype, concession, validity_length_in_days) VALUES (114, 37, 'OfferSeasonTicket', 'REDUCED_FARE', 1);
INSERT INTO offer(id, price, dtype, concession, validity_length_in_days) VALUES (115, 560, 'OfferSeasonTicket', 'NORMAL', 2);
INSERT INTO offer(id, price, dtype, concession, validity_length_in_days) VALUES (116, 280, 'OfferSeasonTicket', 'REDUCED_FARE', 2);
```
