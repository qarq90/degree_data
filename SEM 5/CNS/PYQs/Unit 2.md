---
share_link: https://share.note.sx/w34rv248#urNlfTVkUDoVp/E5aQ85ldyDXz55302QLDxohO/OYlQ
share_updated: 2025-11-13T08:55:34+05:30
---

#### 12) Explain Public Key Cryptography and RSA algorithm.

- Definition:  
    Public Key Cryptography, also known as asymmetric cryptography, uses two different keys — a public key for encryption and a private key for decryption.

- Key Concept:
    - The public key is shared openly.
    - The private key is kept secret by the owner.
    - Data encrypted with one key can only be decrypted with the other.

- Advantages:
    - Provides confidentiality, authentication, and non-repudiation.
    - Eliminates the need to share secret keys over insecure channels.

- RSA Algorithm (Rivest–Shamir–Adleman):
    - One of the most widely used public key cryptographic algorithms.
    - Based on the mathematical difficulty of factoring large prime numbers.

- Steps in RSA:
    1. Choose two large prime numbers p and q.
    2. Compute n = p × q and φ(n) = (p−1)(q−1).
    3. Select a public key e such that 1 < e < φ(n) and gcd(e, φ(n)) = 1.
    4. Compute the private key d where (d × e) mod φ(n) = 1.
    5. Encryption: C=Memod  nC = M^e \mod nC=Memodn
    6. Decryption: M=Cdmod  nM = C^d \mod nM=Cdmodn

- Applications:  
    Used in digital signatures, secure email, SSL/TLS, and data encryption.

---
### 15 & 16) Different Block Cipher Modes

Block cipher modes describe how data blocks are encrypted and connected. They help increase the security, reliability, and flexibility of encryption.

### 1. Electronic Codebook (ECB) Mode

Working:  
Each plaintext block is encrypted independently with the same secret key. Identical plaintext blocks produce identical ciphertext blocks.  

Effect:  
Simple and fast but produces visible patterns in the ciphertext when data repeats.  

Security:  
Lowest security — identical inputs give identical outputs. Not suitable for large data.  

```vb
Plaintext:  P1  P2  P3  
Encryption: |E| |E| |E|  
Ciphertext: C1  C2  C3
```
### 2. Cipher Block Chaining (CBC) Mode

Working:  
Each plaintext block is XORed with the previous ciphertext before encryption. The first block uses an Initialization Vector (IV).  

Effect:  
Ensures that even if plaintext blocks repeat, ciphertext blocks differ.  

Security:  
High security — each block depends on the previous one, hiding patterns effectively.  

```vb
IV → XOR → E → C1  
C1 → XOR → E → C2  
C2 → XOR → E → C3
```
### 3. Cipher Feedback (CFB) Mode

Working:  
Turns the block cipher into a stream cipher. The previous ciphertext is encrypted and XORed with the current plaintext block.  

Effect:  
Error in one block affects only the next few blocks.  

Security:  
Moderate to high security — provides feedback chaining but slightly slower due to dependency.  

```vb
IV → E → XOR → C1  
C1 → E → XOR → C2  
C2 → E → XOR → C3
```
### 4. Output Feedback (OFB) Mode

Working:  
Similar to CFB, but the encryption output (not ciphertext) is used for the next step. The output is XORed with plaintext to produce ciphertext.  

Effect:  
Errors do not spread; each block can be processed independently once the keystream is generated.  

Security:  
High security — no error propagation and suitable for real-time communications.  

```vb
IV → E → O1 → XOR → C1  
O1 → E → O2 → XOR → C2  
O2 → E → O3 → XOR → C3
```
### 5. Counter (CTR) Mode

Working:  
A counter value (CTR1, CTR2, ...CTRn) is encrypted for each block, and the output is XORed with the plaintext.  

Effect:  
Allows parallel processing since each counter is independent. Very efficient for large data.  

Security:  
Very high security — no block repetition and supports random access to encrypted data.  

```vb
CTR1 → E → O1 → XOR → C1  
CTR2 → E → O2 → XOR → C2  
CTR3 → E → O3 → XOR → C3
```

### Comparison Table

| Mode | Working Principle | Effect | Security Level | Parallel Processing |
|-----------|----------------------|-------------|--------------------|--------------------------|
| ECB | Encrypts each block independently | Fast but pattern visible | Low | Yes |
| CBC | XOR with previous ciphertext | Hides repetition | High | No |
| CFB | Uses ciphertext feedback | Limited error spread | Medium-High | No |
| OFB | Uses output feedback | No error propagation | High | Yes |
| CTR | Encrypts counter values | Very fast and flexible | Very High | Yes |
