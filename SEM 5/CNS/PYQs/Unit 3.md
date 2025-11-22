### 19. Compare HMAC and CMAC.

| Aspect              | HMAC (Hash-based Message Authentication Code)      | CMAC (Cipher-based Message Authentication Code)    |
| ------------------- | -------------------------------------------------- | -------------------------------------------------- |
| Basis               | Uses a cryptographic hash function.                | Uses a block cipher (like AES or DES).             |
| Algorithm Type      | Hash-based algorithm.                              | Cipher-based algorithm.                            |
| Input Key Size      | Can vary; depends on hash function.                | Must match the block cipher key length.            |
| Speed               | Generally faster due to lightweight hashing.       | Slightly slower due to encryption operations.      |
| Security Dependence | Depends on hash function strength (e.g., SHA-256). | Depends on block cipher strength (e.g., AES).      |
| Output Length       | Depends on hash output (e.g., 256 bits).           | Equal to block cipher block size (e.g., 128 bits). |
| Common Use          | Authentication in TLS, IPSec, etc.                 | Authentication in AES-based systems.               |
| Example Functions   | HMAC-SHA256, HMAC-MD5.                             | AES-CMAC, 3DES-CMAC.                               |

 Summary:
Both HMAC and CMAC provide message authentication and integrity verification.  
- HMAC uses hashing, better for systems optimized for hash functions.  
- CMAC uses encryption, preferred when AES is already implemented for encryption.

---

### 20. What is the significance of a digital signature on a certificate? Justify.

A digital signature on a certificate ensures the authenticity, integrity, and validity of the certificate issued by a Certificate Authority (CA).

 Significance:
1. Authenticity:  
   Confirms that the certificate was issued by a trusted CA.
2. Integrity:  
   Guarantees that the certificate content has not been altered.
3. Non-repudiation:  
   The CA cannot deny having issued the certificate.
4. Trust Establishment:  
   Helps verify that the public key belongs to the claimed entity.

 Justification:
Without a digital signature, anyone could forge or alter certificates, leading to impersonation attacks.  
The CA’s signature ensures the certificate is genuine and tamper-proof, forming the foundation of Public Key Infrastructure (PKI) trust.

---

### 21. Design a sample digital certificate and explain each field of it.

 Sample Digital Certificate:

```yaml
Version: v3
Serial Number: 123456789
Signature Algorithm: SHA256withRSA
Issuer: CN=GlobalSign CA, O=GlobalSign, C=US
Validity:
    Not Before: 2025-01-01
    Not After: 2026-01-01
Subject: CN=www.example.com, O=Example Ltd, C=IN
Subject Public Key Info:
    Algorithm: RSA
    Public Key: (2048-bit key)
Extensions:
    Key Usage: Digital Signature, Key Encipherment
    Subject Alternative Name: www.example.com, example.com
Signature:
    [Signed using GlobalSign CA’s Private Key]
```

 Explanation of Fields:

| Field | Description |
|------------|-----------------|
| Version | Specifies the X.509 version (v3 is standard). |
| Serial Number | Unique ID assigned by the CA for certificate tracking. |
| Signature Algorithm | Algorithm used by the CA to sign (e.g., SHA-256 with RSA). |
| Issuer | Identifies the Certificate Authority that issued the certificate. |
| Validity | Specifies the time period during which the certificate is valid. |
| Subject | Identifies the entity to which the certificate belongs (domain, organization). |
| Public Key Info | Contains the entity’s public key and its algorithm. |
| Extensions | Additional attributes such as key usage and alternate names. |
| Signature | CA’s digital signature verifying the certificate’s authenticity. |

---

### 22. What is PKI? Explain PKI architecture in detail.

Definition:
Public Key Infrastructure (PKI) is a framework of policies, hardware, software, and procedures used to create, manage, distribute, use, store, and revoke digital certificates.

**Architecture Components:**
1. **Certificate Authority (CA):** Issues and signs digital certificates.
2. **Registration Authority (RA):** Verifies user identity before certificate issuance.
3. **Certificate Database:** Stores all issued certificates.
4. **Certificate Repository:** Provides access to valid certificates.
5. **Certificate Revocation List (CRL):** Lists invalid or revoked certificates.
6. **End Entities:** Users, organizations, or devices using certificates.
7. **Validation Authority (OCSP):** Provides real-time certificate validation.

**Working:**
1. User requests a certificate from RA.
2. RA validates identity and forwards to CA.
3. CA issues a signed certificate.
4. Certificate is stored in repository and used for secure communication.

 Purpose:
- Secure communication over insecure networks.  
- Enable encryption, authentication, and digital signatures.

---

### 23. Explain Kerberos Protocol in detail.

Definition:
Kerberos is a network authentication protocol that uses symmetric key cryptography and a trusted third party to authenticate users securely over insecure networks.

 Key Components:
1. Authentication Server (AS):  
   Verifies user credentials and issues a Ticket Granting Ticket (TGT).
2. Ticket Granting Server (TGS):  
   Issues service tickets for accessing specific network services.
3. Client:  
   The user or system requesting authentication.
4. Service Server (SS):  
   The server providing the requested service.

 Kerberos Authentication Process:

1. Authentication Request (AS_REQ):  
   Client sends a request to the AS with its ID.
2. Authentication Reply (AS_REP):  
   AS verifies user credentials and sends a TGT encrypted with the client’s secret key.
3. Ticket Granting Request (TGS_REQ):  
   Client sends the TGT to the TGS when requesting access to a service.
4. Ticket Granting Reply (TGS_REP):  
   TGS issues a service ticket for the requested service.
5. Client/Server Authentication (AP_REQ / AP_REP):  
   Client presents the service ticket to the server, which validates and grants access.

 Advantages:
- Single login for multiple services.  
- Prevents password transmission in plaintext.  
- Mutual authentication between client and server.

---

### 24. Show how a Kerberos protocol can be used to achieve single sign-on in distributed systems.

 Single Sign-On (SSO) with Kerberos:

Single Sign-On (SSO) allows a user to log in once and gain access to multiple systems without re-entering credentials.

 How Kerberos Enables SSO:

1. Initial Login:  
   - User enters credentials once.  
   - Authentication Server (AS) verifies and issues a Ticket Granting Ticket (TGT).
2. Requesting Services:  
   - When accessing a service, the client presents the TGT to the Ticket Granting Server (TGS).  
   - TGS issues a Service Ticket (ST) for the requested service.
1. Access Service:  
   - The client presents the ST to the Service Server (SS).  
   - If valid, access is granted without re-entering credentials.

 Result:
- The user authenticates once and can access multiple applications across the distributed system seamlessly.  
- Authentication is handled using secure encrypted tickets instead of passwords.

 Benefits:
- Eliminates repeated logins.  
- Reduces password fatigue and phishing risks.  
- Improves user experience and system security.
