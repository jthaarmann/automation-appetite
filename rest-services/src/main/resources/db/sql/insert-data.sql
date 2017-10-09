INSERT into account values (1, 'testing', 'this is a test decription');

INSERT into day values (1, 'Su', 'Sunday');
INSERT into day values (2, 'M', 'Monday');
INSERT into day values (3, 'Tu', 'Tuesday');
INSERT into day values (4, 'W', 'Wednesday');
INSERT into day values (5, 'Th', 'Thursday');
INSERT into day values (6, 'F', 'Friday');
INSERT into day values (7, 'Sa', 'Saturday');

INSERT into food_group values ('Fruit');
INSERT into food_group values ('Vegetable');
INSERT into food_group values ('Grain');
INSERT into food_group values ('Protein');
INSERT into food_group values ('Other');

INSERT into food_item values (1, 'Carrots', 'Vegetable');
INSERT into food_item values (2, 'Broccoli', 'Vegetable');
INSERT into food_item values (3, 'Tomatoes', 'Fruit');
INSERT into food_item values (4, 'Apples', 'Fruit');
INSERT into food_item values (5, 'Bananas', 'Fruit');
INSERT into food_item values (6, 'Spinach', 'Vegetable');
INSERT into food_item values (7, 'Rice', 'Grain');
INSERT into food_item values (8, 'Bread', 'Grain');
INSERT into food_item values (9, 'Quinoa', 'Grain');
INSERT into food_item values (10, 'Chicken', 'Protein');
INSERT into food_item values (11, 'Beef', 'Protein');
INSERT into food_item values (12, 'Salmon', 'Protein');
INSERT into food_item values (13, 'Tofu', 'Protein');
INSERT into food_item values (14, 'Soda', 'Other');
INSERT into food_item values (15, 'Candy', 'Other');

INSERT into food_portion values (1, 1, 1);
INSERT into food_portion values (2, 1, 1);
INSERT into food_portion values (3, 2, 1);
INSERT into food_portion values (4, 2, 1);
INSERT into food_portion values (5, 4, 1);
INSERT into food_portion values (6, 8, 1);
INSERT into food_portion values (7, 8, 1);
INSERT into food_portion values (8, 8, 1);
INSERT into food_portion values (9, 10, 1);
INSERT into food_portion values (10, 10, 1);
INSERT into food_portion values (11, 14, 1);
INSERT into food_portion values (12, 15, 1);


INSERT into food_portion values (21, 5, 2);
INSERT into food_portion values (22, 3, 2);
INSERT into food_portion values (23, 1, 2);
INSERT into food_portion values (24, 9, 2);
INSERT into food_portion values (25, 12, 2);
INSERT into food_portion values (26, 13, 2);
INSERT into food_portion values (27, 3, 2);
INSERT into food_portion values (28, 3, 2);
INSERT into food_portion values (29, 8, 2);
INSERT into food_portion values (30, 10, 2);
INSERT into food_portion values (31, 12, 2);
INSERT into food_portion values (32, 13, 2);
INSERT into food_portion values (33, 2, 2);
INSERT into food_portion values (34, 4, 2);
INSERT into food_portion values (35, 14, 2);
INSERT into food_portion values (36, 14, 2);

INSERT into food_portion values (41, 1, 3);
INSERT into food_portion values (42, 5, 3);
INSERT into food_portion values (43, 8, 3);
INSERT into food_portion values (44, 8, 3);
INSERT into food_portion values (45, 8, 3);
INSERT into food_portion values (46, 8, 3);
INSERT into food_portion values (47, 11, 3);
INSERT into food_portion values (48, 12, 3);
INSERT into food_portion values (49, 13, 3);
INSERT into food_portion values (50, 3, 3);

INSERT into food_portion values (51, 4, 4);
INSERT into food_portion values (52, 4, 4);
INSERT into food_portion values (53, 15, 4);
INSERT into food_portion values (54, 3, 4);
INSERT into food_portion values (55, 3, 4);
INSERT into food_portion values (56, 3, 4);
INSERT into food_portion values (57, 11, 4);
INSERT into food_portion values (58, 11, 4);
INSERT into food_portion values (59, 15, 4);
INSERT into food_portion values (60, 14, 4);
INSERT into food_portion values (61, 15, 4);
INSERT into food_portion values (62, 14, 4);

INSERT into food_portion values (71, 11, 7);
INSERT into food_portion values (72, 11, 7);
INSERT into food_portion values (73, 11, 7);
INSERT into food_portion values (74, 1, 7);
INSERT into food_portion values (75, 1, 7);
INSERT into food_portion values (76, 1, 7);
INSERT into food_portion values (77, 1, 7);
INSERT into food_portion values (78, 5, 7);
INSERT into food_portion values (79, 6, 7);
INSERT into food_portion values (80, 5, 7);
INSERT into food_portion values (81, 6, 7);
INSERT into food_portion values (82, 8, 7);
INSERT into food_portion values (83, 8, 7);
INSERT into food_portion values (84, 8, 7);
INSERT into food_portion values (85, 9, 7);
INSERT into food_portion values (86, 7, 7);

INSERT into food_portion values (91, 2, 5);
INSERT into food_portion values (92, 2, 5);
INSERT into food_portion values (93, 2, 5);
INSERT into food_portion values (94, 5, 5);
INSERT into food_portion values (95, 5, 5);
INSERT into food_portion values (96, 5, 5);
INSERT into food_portion values (97, 8, 5);
INSERT into food_portion values (98, 8, 5);
INSERT into food_portion values (99, 9, 5);
INSERT into food_portion values (100, 14, 5);
INSERT into food_portion values (101, 15, 5);
INSERT into food_portion values (102, 13, 5);

INSERT into food_portion values (111, 6, 6);
INSERT into food_portion values (112, 3, 6);
INSERT into food_portion values (113, 3, 6);
INSERT into food_portion values (114, 2, 6);
INSERT into food_portion values (115, 5, 6);
INSERT into food_portion values (116, 5, 6);
INSERT into food_portion values (117, 11, 6);
INSERT into food_portion values (118, 11, 6);
INSERT into food_portion values (119, 10, 6);
INSERT into food_portion values (120, 15, 6);
INSERT into food_portion values (121, 15, 6);

INSERT into exercise_type values ('E', 'Endurance');
INSERT into exercise_type values ('S', 'Strength');
INSERT into exercise_type values ('B', 'Balance');
INSERT into exercise_type values ('F', 'Flexibility');


INSERT into exercise values (1, 'Walking', 'E');
INSERT into exercise values (2, 'Running', 'E');
INSERT into exercise values (3, 'Cycling', 'E');
INSERT into exercise values (4, 'Swimming', 'E');
INSERT into exercise values (5, 'Bench Press', 'S');
INSERT into exercise values (6, 'Push Ups', 'S');
INSERT into exercise values (7, 'Dead Lift', 'S');
INSERT into exercise values (8, 'Squats', 'S');
INSERT into exercise values (9, 'Tai Chi', 'B');
INSERT into exercise values (10, 'Heel to toe walk', 'B');
INSERT into exercise values (11, 'Standing on one foot', 'B');
INSERT into exercise values (13, 'Yoga', 'F');
INSERT into exercise values (14, 'Leg Stretch', 'F');
INSERT into exercise values (15, 'Back Stretch', 'F');

INSERT into exercise_session values (1, 1, 1);
INSERT into exercise_session values (2, 10, 1);
INSERT into exercise_session values (3, 2, 1);
INSERT into exercise_session values (4, 14, 1);

INSERT into exercise_session values (5, 3, 2);
INSERT into exercise_session values (6, 15, 2);
INSERT into exercise_session values (7, 14, 2);

INSERT into exercise_session values (9, 13, 3);
INSERT into exercise_session values (10, 13, 3);

INSERT into exercise_session values (11, 5, 4);
INSERT into exercise_session values (12, 8, 4);

INSERT into exercise_session values (21, 10, 5);
INSERT into exercise_session values (22, 11, 5);
INSERT into exercise_session values (23, 2, 5);
INSERT into exercise_session values (24, 2, 5);

INSERT into exercise_session values (25, 13, 6);
INSERT into exercise_session values (26, 13, 6);

INSERT into exercise_session values (27, 4, 7);
