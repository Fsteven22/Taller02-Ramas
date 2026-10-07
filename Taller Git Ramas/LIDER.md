# Para el Líder del Grupo 👑

## Tu responsabilidad: 20 minutos

### 1️⃣ Crear Repositorio en GitHub (5 min)
- Ve a GitHub.com → "+" → "New repository"
- Nombre: `Taller02-Ramas`
- Tipo: **Public**
- NO inicializar con README
- Crear

### 2️⃣ Agregar Colaboradores (3 min)
- En tu repo: Settings → Collaborators → Add people
- Busca y agrega el usuario GitHub de cada integrante

### 3️⃣ Configurar SSH (2 min - si no lo has hecho)
```bash
ssh-keygen -t ed25519 -C "tu@correo.com"
# Presiona Enter 3 veces

# Copia tu clave pública y agrega en:
# GitHub > Settings > SSH and GPG keys > New SSH key
```

### 4️⃣ Clonar y Subir Código (10 min)
```bash
# Clonar repo
git clone git@github.com:TU_USUARIO/Taller02-Ramas.git
cd Taller02-Ramas

# Descomprimir TopMusical.zip aquí

# Configurar tu Git
git config --local user.name "Tu Nombre"
git config --local user.email "tu@correo.com"

# Subir código base
git add .
git commit -m "Código base TopMusical"
git push origin main

# Verificar en GitHub.com que se subió
```

---

## ✅ Verifica que esté listo
1. ¿Ves TopMusical/ en GitHub? ✓
2. ¿Están agregados todos como Collaborators? ✓
3. ¿Tu Git local está configurado? ✓

---

## Tu parte del taller (como estudiante)

Después de configurar, sigue la guía normal:

1. Crea rama `titulo`
2. Cambio: nuevo nombre para el Top 10
3. Commit y push
4. Fusiona con main
5. Resuelve conflictos si hay

---

**Luego avisa al grupo:** "Repo listo. Clonen y lean `guia.md` en GitHub."