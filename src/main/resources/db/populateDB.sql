INSERT INTO objects (object_type, data, parent_object_id)
VALUES (1, '{
  "name": "baz"
}', 0),
       (2, '{
         "name": "baz1"
       }', 1),
       (2, '{
         "name": "baz2"
       }', 1),
       (1, '{
         "name": "baz3"
       }', 2),
       (3, null, 3),
       (1, '{
         "name": "baz5"
       }', 2),
       (2, '{
         "name": "baz6"
       }', 2),
       (2, '{
         "name": "baz7"
       }', 3),
       (1, '{
         "name": "baz8"
       }', 4),
       (3, '{
         "name": "baz9"
       }', 4),
       (1, null, 4),
       (2, '{
         "name": "baz11"
       }', 4),
       (2, '{
         "name": "baz12"
       }', 5),
       (1, null, 5),
       (3, '{
         "name": "baz14"
       }', 5),
       (1, '{
         "name": "baz15"
       }', 5);