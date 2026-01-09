-- 1. Tabla Administradores
CREATE TABLE IF NOT EXISTS administradores (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    contraseña VARCHAR(255) NOT NULL
);

-- 2. Tabla Socios
CREATE TABLE IF NOT EXISTS socios (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    n_socio INT UNIQUE NOT NULL,
    dni VARCHAR(20) UNIQUE NOT NULL,
    t_socio VARCHAR(50) NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL,
    recibe_notificaciones BOOLEAN DEFAULT TRUE
);

-- 3. Tabla Carnets
CREATE TABLE IF NOT EXISTS carnets (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    fecha_emision DATE,
    id_socio BIGINT UNIQUE,

    CONSTRAINT fk_carnet_socio
        FOREIGN KEY (id_socio)
        REFERENCES socios(id)
        ON DELETE CASCADE
);

-- 4. Tabla Eventos
CREATE TABLE IF NOT EXISTS eventos (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    descripcion TEXT,
    fecha DATE,
    ubicacion VARCHAR(255)
);

-- 5. Tabla Asistencias
CREATE TABLE IF NOT EXISTS asistencias (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    fecha_evento DATE,                -- Fecha específica de la asistencia
    id_evento BIGINT NOT NULL,
    id_socio BIGINT NOT NULL,

    CONSTRAINT fk_asistencia_evento
        FOREIGN KEY (id_evento)
        REFERENCES eventos(id)
        ON DELETE CASCADE,

    CONSTRAINT fk_asistencia_socio
        FOREIGN KEY (id_socio)
        REFERENCES socios(id)
        ON DELETE CASCADE
);