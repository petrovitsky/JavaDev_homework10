INSERT INTO CLIENT (name) VALUES
    ('Bibby'),
    ('Demetria'),
    ('Harrison'),
    ('Natalie'),
    ('Gal'),
    ('Sula'),
    ('Cullin'),
    ('Sybilla'),
    ('Thorny'),
    ('Otha');
INSERT INTO PLANET (id, name) VALUES
        ( 'MARS', 'Mars' ),
        ( 'EARTH' , 'Earth' ),
        ( 'VENUS' , 'Venus' ),
        ( 'PLUTO', 'Pluto' ),
        ( 'SATURN', 'Saturn' );
INSERT INTO TICKET (CLIENT_ID, FROM_PLANET_ID, TO_PLANET_ID) VALUES
        ( 1, 'EARTH', 'VENUS'),
        ( 2, 'SATURN', 'PLUTO'),
        ( 8, 'EARTH', 'MARS'),
        ( 4, 'MARS', 'EARTH'),
        ( 3, 'PLUTO', 'VENUS'),
        ( 2, 'VENUS', 'PLUTO'),
        ( 9,'EARTH', 'SATURN'),
        ( 3, 'MARS', 'SATURN'),
        ( 6, 'SATURN', 'EARTH');