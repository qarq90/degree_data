---
share_link: https://share.note.sx/jdkm4n17#6u0rI0IFyP7oDZ1aMsmuvZ6bR3mGUe5gNTa9dexZIkw
share_updated: 2025-11-13T08:55:39+05:30
---
### 1. Explain Security Services and mechanisms to implement it.

- **Security services** provide protection to ensure secure data exchange over a network by safeguarding information from unauthorized access, alteration, and disruption. 
- They maintain confidentiality, integrity, authentication, non-repudiation, access control, and availability — ensuring that communication between entities remains trustworthy, reliable, and resilient against potential threats or attacks.

| **Security Principle** | **Description**                                                                                                          | **Mechanisms / Techniques**               |
| ---------------------- | ------------------------------------------------------------------------------------------------------------------------ | ----------------------------------------- |
| **Confidentiality**    | Ensures that data is not disclosed to unauthorized individuals, entities, or processes.                                  | Encryption, ACLs, Traffic Padding         |
| **Integrity**          | Ensures that data has not been altered or destroyed in an unauthorized manner.                                           | Hashing, MACs, Digital Signatures         |
| **Authentication**     | Verifies the identity of a user, system, or entity.                                                                      | Passwords, OTPs, Biometrics, Certificates |
| **Non-Repudiation**    | Prevents an entity from denying having performed a previous action or commitment; provides proof of origin and delivery. | Digital Signatures, Timestamps            |
| **Access Control**     | Restricts and controls access to resources (systems, files, data) based on identity and policy.                          | ACLs, RBAC, Security Tokens               |
| **Availability**       | Ensures that systems and resources are accessible and usable upon demand by an authorized entity.                        | Redundancy, Backups, DoS Protection       |

Security Mechanisms (Implementation Tools):
- Encryption: Provides confidentiality.  
- Digital Signatures: Provides authentication and integrity.  
- Hash Functions: Verifies data integrity.  
- Firewalls / IDS: Prevent and detect attacks.  
- Authentication Protocols: e.g., Kerberos, OAuth.  
- Access Control Lists (ACLs): Manage user permissions.

---
### 2. Distinguish between passive and active security attacks.

| Basis | Passive Attack | Active Attack |
|------------|--------------------|-------------------|
| Objective | To obtain information without altering data. | To alter, disrupt, or destroy data. |
| Nature | Silent and undetectable. | Easily detectable. |
| Examples | Eavesdropping, traffic analysis. | Modification, denial of service, masquerade, replay. |
| Effect | Affects confidentiality. | Affects integrity and availability. |
| Countermeasures | Encryption, traffic padding. | Authentication, intrusion detection, firewalls. |

---
### 3. Enlist security goals. Discuss their significance.

|**Security Principle**|**Description**|**Significance**|
|---|---|---|
|**Confidentiality**|Ensures that data is not disclosed to unauthorized individuals, entities, or processes.|Protects sensitive data from unauthorized access.|
|**Integrity**|Ensures that data has not been altered or destroyed in an unauthorized manner.|Maintains accuracy and trustworthiness of data.|
|**Authentication**|Verifies the identity of a user, system, or entity.|Confirms that entities are who they claim to be.|
|**Non-Repudiation**|Prevents an entity from denying having performed a previous action or commitment; provides proof of origin and delivery.|Provides accountability and proof of actions.|
|**Access Control**|Restricts and controls access to resources (systems, files, data) based on identity and policy.|Ensures only authorized users can access resources.|
|**Availability**|Ensures that systems and resources are accessible and usable upon demand by an authorized entity.|Guarantees reliable and timely access to data/services.|

---
### 4. Explain the OSI Security Architecture and Network Security Model.

OSI Security Architecture:
Defines a framework to provide network security through:
- Security attacks: Threats to data (passive, active).  
- Security mechanisms: Tools to detect/prevent attacks.  
- Security services: Functions ensuring secure communication.

Components:
1. Security Attack: Any action compromising security.  
2. Security Mechanism: Detects, prevents, or recovers from attacks.  
3. Security Service: Provides confidentiality, integrity, authentication, etc.

Network Security Model:
1. Sender and Receiver: Communicate securely.  
2. Security Transformation: (e.g., encryption) applied to data.  
3. Secret Information: Keys or credentials used for protection.  
4. Opponent: Tries to compromise the communication.  
5. Trusted Third Party: Assists in key management and authentication.

---
### 5. SHA provides better security than MD5 — Justify.

| Aspect | MD5 | SHA (SHA-1 / SHA-2 / SHA-3) |
|-------------|----------|----------------------------------|
| Hash Size | 128 bits | 160 / 256 / 512 bits |
| Collision Resistance | Weak (collisions found) | Strong |
| Security Level | Low (outdated) | High (modern cryptography) |
| Use Case | Checksums, non-critical data | Digital signatures, SSL, encryption |

Justification:
SHA (Secure Hash Algorithm) produces longer and more complex hash values than MD5, making it more resistant to brute-force and collision attacks. Thus, SHA provides better security for digital integrity verification and encryption.

---
### 6. Explain different types of denial of service attacks.

A **Denial of Service (DoS) attack** is an attempt to make a computer system, service, or network unavailable to its intended users by overwhelming it with excessive requests or exploiting vulnerabilities.  
When multiple systems coordinate such attacks, it is called a **Distributed Denial of Service (DDoS)** attack.

| **Type of DoS Attack**                 | **Description**                                                                                                                                       |
| -------------------------------------- | ----------------------------------------------------------------------------------------------------------------------------------------------------- |
| **1. Volume-based attacks**            | Flood the target with massive traffic to consume all bandwidth. _Example:_ ICMP Flood, UDP Flood.                                                  |
| **2. Protocol-based attacks**          | Exploit weaknesses in network protocols to exhaust server resources. _Example:_ SYN Flood, Ping of Death, Smurf Attack.                            |
| **3. Application-layer attacks**       | Target specific applications or services by sending legitimate-looking but malicious requests. _Example:_ HTTP Flood, Slowloris Attack.            |
| **4. Distributed DoS (DDoS)**          | Uses multiple compromised systems (botnets) to launch large-scale attacks simultaneously.                                                             |
| **5. Reflected/Amplification attacks** | Attackers send requests with spoofed IPs to servers, causing large responses to flood the victim. _Example:_ DNS Amplification, NTP Amplification. |

---
### 7. What is Steganography and its applications?

Definition:
Steganography is the technique of hiding secret information within another non-secret medium (e.g., image, audio, or video) so that it remains undetectable.
Unlike cryptography, which hides the content of a message, **steganography hides the fact that a message exists**.

Example:
Hiding a confidential message inside the pixel data of an image.

Techniques:
- **Least Significant Bit (LSB)** insertion in images  
- **Echo hiding** in audio  
- **Whitespace manipulation** in text

Applications:
1. Covert Communication: Secret data exchange.  
2. Digital Watermarking: Embed ownership or copyright info.  
3. Confidential Data Storage: Hide sensitive data in media.  
4. Authentication: Validate originality of content.  
5. Military / Intelligence Use: Secure message transmission.
