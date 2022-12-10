create table specifiedschema.images (
    id SERIAL primary key,
    filename text not null unique
)