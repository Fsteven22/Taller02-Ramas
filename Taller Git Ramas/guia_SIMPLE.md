# Taller Git - Ramas y Colaboración

## 🎯 Objetivos
- Crear ramas de Git para desarrollo paralelo
- Resolver conflictos al fusionar cambios
- Trabajar colaborativamente con GitHub

---

## 📋 Rúbrica (100 pts)
| Criterio | Puntos |
|----------|--------|
| Creación de rama | 20 |
| Subir rama al remoto | 20 |
| Unificar ramas | 50 |
| Configuración Git local | 10 |

---

## 🚀 Procedimiento Rápido

### PASO 1: Líder crea repositorio (15 min)
1. En GitHub: New repository → `Taller02-Ramas` (Public)
2. Settings > Collaborators → Agregar usuarios del grupo
3. Clonar: `git clone <URL>`
4. Descomprimir `TopMusical.zip` en la carpeta
5. Commit y push: 
   ```bash
   git add .
   git commit -m "Código base TopMusical"
   git push origin main
   ```

### PASO 2: Configurar tu Git (Todos - IMPORTANTE)
```bash
git config --local user.name "Tu Nombre"
git config --local user.email "tu@correo.com"
```

### PASO 3: Todos clonan el repo
```bash
git clone <URL>
cd Taller02-Ramas/TopMusical
```

### PASO 4: Crear tu rama y hacer cambios

#### 👑 **LÍDER - Rama "titulo"**
```bash
git branch titulo
git checkout titulo
```
**Cambio:** En `TopMusical/src/main/java/espol/poo/topmusical/PrimaryController.java`
- Busca donde se define el título (algo como "Top 10")
- **Cámbialo a un nuevo nombre** (ej: "🎵 Top 10 de las Mejores Canciones")
- Ejecuta, verifica que funcione, toma captura

#### 👤 **INTEGRANTE 1 - Rama "orden"**
```bash
git branch orden
git checkout orden
```
**Cambio:** En `TopMusical/src/main/java/modelo/Cancion.java`
- **Invierte el orden** del Top 10 (de ascendente a descendente)
- Ejecuta, verifica, toma captura

#### 👤 **INTEGRANTE 2 - Rama "artista"**
```bash
git branch artista
git checkout artista
```
**Cambio:** En `PrimaryController.java`
- **Muestra el artista en el título** de la canción
- Formato: "Artista - Nombre Canción"
- Ejecuta, verifica, toma captura

#### 👤 **INTEGRANTE 3 - Rama "numero"** (si existe)
```bash
git branch numero
git checkout numero
```
**Cambio:** En `PrimaryController.java`
- **Agregar número de posición** al lado derecho
- Formato: "Nombre Canción  #1", "Nombre Canción  #2", etc.
- Ejecuta, verifica, toma captura

#### 👤 **INTEGRANTE 4 - Rama "info"** (si existe)
```bash
git branch info
git checkout info
```
**Cambio:** En `PrimaryController.java`
- **Mostrar nombre del artista** en el panel derecho (al hacer clic en una canción)
- Ejecuta, verifica, toma captura

### PASO 5: Guardar y subir
```bash
git add .
git commit -m "Descripción del cambio"
git push origin <tu-rama>
```

### PASO 6: Fusionar con main (Cada quien)
```bash
git checkout main
git pull origin main
git merge <tu-rama>

# SI HAY CONFLICTOS:
# - Abrir archivo conflictivo
# - Mantener AMBOS cambios (eliminar marcas <<<<, ====, >>>>)
# - Guardar

git add .
git commit -m "Resolviendo conflictos"
git push origin main
```

---

## 🔑 Comandos Esenciales
```bash
git status                          # Ver estado
git branch                          # Ver ramas
git checkout <rama>                 # Cambiar rama
git add .                           # Agregar cambios
git commit -m "mensaje"             # Crear commit
git push origin <rama>              # Subir rama
git pull origin main                # Descargar cambios
git merge <rama>                    # Fusionar
git log --all --graph --oneline     # Ver historial
```

---

## ⚠️ Problemas Comunes

**"Permission denied (publickey)"**
```bash
ssh -T git@github.com  # Si dice "Hi usuario" - ¡OK!
```

**"Hay conflictos en el merge"**
- Abre el archivo conflictivo
- Busca `<<<<<<`, `======`, `>>>>>>`
- Mantén AMBOS cambios, elimina las marcas
- Haz commit del merge

**"Cambié de rama pero tengo cambios sin guardar"**
```bash
git add .
git commit -m "tu mensaje"
git checkout otra-rama
```

---

## ✅ Checklist Final
- [ ] Configuré `user.name` y `user.email` en Git
- [ ] Creé mi rama
- [ ] Hice cambios en el código
- [ ] Hice commit descriptivo
- [ ] Subí mi rama al remoto
- [ ] Fusioné con main
- [ ] Resolví conflictos
- [ ] Verifiqué en GitHub que los cambios están

---

**Lee esto en GitHub directamente desde el repositorio.**
**¡Éxito!** 🚀