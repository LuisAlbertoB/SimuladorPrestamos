# 💰 Simulador de Préstamos Bancarios (Java - MXN)

Este proyecto realiza cálculos detallados sobre préstamos bancarios en Pesos Mexicanos (MXN). 

---

## 🚀 ¿Qué hace?

Calcula con precisión los siguientes detalles para préstamos bancarios:

- **Monto financiado**
- **Cuota mensual**
- **Total a pagar**
- **Intereses totales**

---

## 🛠️ Requisitos

- Java JDK instalado.

---

## 📌 Compilar y Ejecutar

Desde la raíz del proyecto ejecuta:

```bash
javac -d bin src/*.java
java -cp bin InterfazPrestamo
```

---

## 🧮 Operaciones Matemáticas

### 1. 📈 Monto Financiado

\[
\text{Monto financiado} = \text{Monto del préstamo} - \text{Anticipo}
\]

### 2. 📅 Cuota Mensual (Amortización con intereses compuestos)

\[
\text{Cuota mensual} = \text{Monto financiado} \times \frac{i(1+i)^n}{(1+i)^n-1}
\]

- **\( i \)** tasa mensual = tasa anual / 12 / 100
- **\( n \)** número total de pagos en meses

### 3. 💳 Total a Pagar

\[
\text{Total a pagar} = \text{Cuota mensual} \times n
\]

### 4. 💸 Intereses Totales

\[
\text{Intereses totales} = \text{Total a pagar} - \text{Monto financiado}
\]

---

## 📖 Tecnología usada

- **Java**
- **Swing** (Interfaz gráfica)

---

## 👤 Autor

Creado por Luis Alberto Batalla Gonzalez

## Link Repositorio

https://github.com/LuisAlbertoB/SimuladorPrestamos.git
