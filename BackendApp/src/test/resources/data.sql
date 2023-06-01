INSERT INTO offers(offer_id, price, dtype, concession, version) VALUES (101, 4.60, 'OfferSingleTicket', 'NORMAL', 1);
INSERT INTO offers(offer_id, price, dtype, concession, version) VALUES (102, 2.30, 'OfferSingleTicket', 'REDUCED_FARE', 1);

INSERT INTO offers(offer_id, price, dtype, concession, validity_length_in_minutes, version) VALUES (103, 3.20, 'OfferCommuterPass', 'NORMAL', 0, 1);
INSERT INTO offers(offer_id, price, dtype, concession, validity_length_in_minutes, version) VALUES (104, 1.60, 'OfferCommuterPass', 'REDUCED_FARE', 0, 1);
INSERT INTO offers(offer_id, price, dtype, concession, validity_length_in_minutes, version) VALUES (105, 4.00, 'OfferCommuterPass', 'NORMAL', 1, 1);
INSERT INTO offers(offer_id, price, dtype, concession, validity_length_in_minutes, version) VALUES (106, 2.00, 'OfferCommuterPass', 'REDUCED_FARE', 1, 1);
INSERT INTO offers(offer_id, price, dtype, concession, validity_length_in_minutes, version) VALUES (107, 5.20, 'OfferCommuterPass', 'NORMAL', 2, 1);
INSERT INTO offers(offer_id, price, dtype, concession, validity_length_in_minutes, version) VALUES (108, 2.60, 'OfferCommuterPass', 'REDUCED_FARE', 2, 1);
INSERT INTO offers(offer_id, price, dtype, concession, validity_length_in_minutes, version) VALUES (109, 15.00, 'OfferCommuterPass', 'NORMAL', 3, 1);
INSERT INTO offers(offer_id, price, dtype, concession, validity_length_in_minutes, version) VALUES (110, 7.50, 'OfferCommuterPass', 'REDUCED_FARE', 3, 1);

INSERT INTO offers(offer_id, price, dtype, concession, validity_length_in_days, version) VALUES (111, 38, 'OfferSeasonTicket', 'NORMAL', 0, 1);
INSERT INTO offers(offer_id, price, dtype, concession, validity_length_in_days, version) VALUES (112, 19, 'OfferSeasonTicket', 'REDUCED_FARE', 0, 1);
INSERT INTO offers(offer_id, price, dtype, concession, validity_length_in_days, version) VALUES (113, 74, 'OfferSeasonTicket', 'NORMAL', 1, 1);
INSERT INTO offers(offer_id, price, dtype, concession, validity_length_in_days, version) VALUES (114, 37, 'OfferSeasonTicket', 'REDUCED_FARE', 1, 1);
INSERT INTO offers(offer_id, price, dtype, concession, validity_length_in_days, version) VALUES (115, 560, 'OfferSeasonTicket', 'NORMAL', 2, 1);
INSERT INTO offers(offer_id, price, dtype, concession, validity_length_in_days, version) VALUES (116, 280, 'OfferSeasonTicket', 'REDUCED_FARE', 2, 1);

INSERT INTO users(user_id, dtype, role, username, password, version) VALUES (101, 'Passenger', 'USER', 'Franciszek', '$2a$10$hVJI1RAzbII3xYc7QfvIYuItRGJ77oWPDpUBdjMbIWnSWkA7f1BhK', 1);
INSERT INTO users(user_id, dtype, role, username, password, version) VALUES (102, 'TicketCollector', 'TICKET_COLLECTOR', 'Michał', '$2a$10$FxZRtyagi8QUNyOE1DusKu.lwWg3Uj8iooKU6K5ucAQrS7SnnNrHm', 1);

INSERT INTO tickets(ticket_id, dtype, clip_time, concession, price, user_id, tram_id, version) VALUES (101, 'SingleTicket', '2023-05-03 04:05:06', 'NORMAL', 4.60, 101, 'A124', 1);
INSERT INTO tickets(ticket_id, dtype, clip_time, concession, price, user_id, validity_length_in_minutes, version) VALUES (102, 'CommuterPass', '2023-05-03 04:05:06', 'NORMAL', 3.20, 101, 0, 1);
INSERT INTO tickets(ticket_id, dtype, clip_time, concession, price, user_id, validity_length_in_days, version) VALUES (103, 'SeasonTicket', '2023-05-03 04:05:06', 'NORMAL', 38, 101, 0, 1);
INSERT INTO tickets(ticket_id, dtype, clip_time, concession, price, user_id, tram_id, version) VALUES (104, 'SingleTicket', '2023-05-04 11:31:00', 'NORMAL', 4.60, 101, '16', 1);
INSERT INTO tickets(ticket_id, dtype, clip_time, concession, price, user_id, validity_length_in_days, version) VALUES (105, 'SeasonTicket', '2023-05-03 04:05:06', 'REDUCED_FARE', 280, 101, 3, 1);
