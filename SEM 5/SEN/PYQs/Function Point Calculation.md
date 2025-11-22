
![[Pasted image 20251115233943.png]]

### Step 1: Use standard FP weights (Average complexity)  
For *average* complexity, the standard weights are:

| Function Type              | Weight |
|---------------------------|--------|
| User Inputs (EI)      | 4      |
| User Outputs (EO)     | 5      |
| User Enquiries (EQ)   | 4      |
| Files (ILF)           | 10     |
| External Interfaces (EIF) | 7 |

### Given:  
- Number of user inputs = 32  
- Number of user outputs = 60  
- Number of user enquiries = 24  
- Number of files = 8  
- Number of external interfaces = 2  
- Sum of complexity adjustment factors = ΣFi = 40

---

## Step 2: Compute Unadjusted Function Points (UFP)

$$
UFP = (32 * 4) + (60 * 5) + (24 * 4) + (8 * 10) + (2 * 7)
$$

### Calculations:
- Inputs: `32 × 4 = 128`  
- Outputs: `60 × 5 = 300`  
- Enquiries: `24 × 4 = 96`  
- Files: `8 × 10 = 80`  
- External interfaces: `2 × 7 = 14`

$$
UFP = 128 + 300 + 96 + 80 + 14 = 618
$$

---

## Step 3: Compute Value Adjustment Factor (VAF)

$$
VAF= 0.65 + 0.01 *  Fi
$$

$$
VAF= 0.65 + 0.01(40) = 0.65 + 0.40 = 1.05
$$

---

## Step 4: Compute Final Function Points (FP)

$$
FP = UFP * VAF
FP = 618 * 1.05 = 648.9 \approx 649
$$

---

# ✅ Final Function Point Value = 649
