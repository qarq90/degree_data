import os
import PyPDF2

def count_pdf_pages(pdf_path):
    try:
        with open(pdf_path, 'rb') as file:
            reader = PyPDF2.PdfReader(file)
            return len(reader.pages)
    except Exception as e:
        print(f"Error reading {pdf_path}: {e}")
        return 0

def main():
    # Get all PDF files in current directory
    pdf_files = [f for f in os.listdir('.') if f.lower().endswith('.pdf')]
    
    if not pdf_files:
        print("No PDF files found in current directory.")
        return
    
    print(f"Found {len(pdf_files)} PDF file(s) in current directory:")
    print("-" * 50)
    
    total_pages = 0
    for pdf in pdf_files:
        page_count = count_pdf_pages(pdf)
        print(f"{pdf}: {page_count} pages")
        total_pages += page_count
    
    print("-" * 50)
    print(f"Total pages across all PDFs: {total_pages}")

if __name__ == "__main__":
    main()
