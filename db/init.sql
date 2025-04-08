CREATE EXTENSION IF NOT EXISTS postgis;

CREATE TABLE location (
                          id SERIAL PRIMARY KEY,
                          name VARCHAR(100),
                          coordinates GEOGRAPHY(POINT, 4326)
);

INSERT INTO location (name, coordinates)
VALUES
    ('서울타워', ST_SetSRID(ST_MakePoint(126.9895, 37.5512), 4326)::geography),
    ('광화문', ST_SetSRID(ST_MakePoint(126.9770, 37.5759), 4326)::geography),
    ('한강공원', ST_SetSRID(ST_MakePoint(126.9396, 37.5286), 4326)::geography);
