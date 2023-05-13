INSERT INTO offers(offer_id, price, dtype, concession) VALUES (101, 4.60, 'OfferSingleTicket', 'NORMAL');
INSERT INTO offers(offer_id, price, dtype, concession) VALUES (102, 2.30, 'OfferSingleTicket', 'REDUCED_FARE');

INSERT INTO offers(offer_id, price, dtype, concession, validity_length_in_minutes) VALUES (103, 3.20, 'OfferCommuterPass', 'NORMAL', 0);
INSERT INTO offers(offer_id, price, dtype, concession, validity_length_in_minutes) VALUES (104, 1.60, 'OfferCommuterPass', 'REDUCED_FARE', 0);
INSERT INTO offers(offer_id, price, dtype, concession, validity_length_in_minutes) VALUES (105, 4.00, 'OfferCommuterPass', 'NORMAL', 1);
INSERT INTO offers(offer_id, price, dtype, concession, validity_length_in_minutes) VALUES (106, 2.00, 'OfferCommuterPass', 'REDUCED_FARE', 1);
INSERT INTO offers(offer_id, price, dtype, concession, validity_length_in_minutes) VALUES (107, 5.20, 'OfferCommuterPass', 'NORMAL', 2);
INSERT INTO offers(offer_id, price, dtype, concession, validity_length_in_minutes) VALUES (108, 2.60, 'OfferCommuterPass', 'REDUCED_FARE', 2);
INSERT INTO offers(offer_id, price, dtype, concession, validity_length_in_minutes) VALUES (109, 15.00, 'OfferCommuterPass', 'NORMAL', 3);
INSERT INTO offers(offer_id, price, dtype, concession, validity_length_in_minutes) VALUES (110, 7.50, 'OfferCommuterPass', 'REDUCED_FARE', 3);

INSERT INTO offers(offer_id, price, dtype, concession, validity_length_in_days) VALUES (111, 38, 'OfferSeasonTicket', 'NORMAL', 0);
INSERT INTO offers(offer_id, price, dtype, concession, validity_length_in_days) VALUES (112, 19, 'OfferSeasonTicket', 'REDUCED_FARE', 0);
INSERT INTO offers(offer_id, price, dtype, concession, validity_length_in_days) VALUES (113, 74, 'OfferSeasonTicket', 'NORMAL', 1);
INSERT INTO offers(offer_id, price, dtype, concession, validity_length_in_days) VALUES (114, 37, 'OfferSeasonTicket', 'REDUCED_FARE', 1);
INSERT INTO offers(offer_id, price, dtype, concession, validity_length_in_days) VALUES (115, 560, 'OfferSeasonTicket', 'NORMAL', 2);
INSERT INTO offers(offer_id, price, dtype, concession, validity_length_in_days) VALUES (116, 280, 'OfferSeasonTicket', 'REDUCED_FARE', 2);

INSERT INTO users(user_id, dtype, username, password) VALUES (101, 'Passenger', 'kamilasproska', 'strongpassword');
INSERT INTO users(user_id, dtype, username, password) VALUES (102, 'TicketCollector', 'jankowalski', 'anotherstrongpassword');

INSERT INTO tickets(ticket_id, dtype, clip_time, concession, price, user_id, tram_id) VALUES (101, 'SingleTicket', '2023-05-03 04:05:06', 'NORMAL', 4.60, 101, 'A124');
INSERT INTO tickets(ticket_id, dtype, clip_time, concession, price, user_id, validity_length_in_minutes) VALUES (102, 'CommuterPass', '2023-05-03 04:05:06', 'NORMAL', 3.20, 101, 0);
INSERT INTO tickets(ticket_id, dtype, clip_time, concession, price, user_id, validity_length_in_days) VALUES (103, 'SeasonTicket', '2023-05-03 04:05:06', 'NORMAL', 38, 101, 0);
INSERT INTO tickets(ticket_id, dtype, clip_time, concession, price, user_id, tram_id) VALUES (104, 'SingleTicket', '2023-05-04 11:31:00', 'NORMAL', 4.60, 101, '16');

