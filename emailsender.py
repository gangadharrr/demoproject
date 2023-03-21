import os
from email.message import EmailMessage
import ssl
import smtplib

email_sender='pinnantiuday@gmail.com'
email_pass="mzfypoqkatxnqbdc"
email_recevier='tagbotroadster@gmail.com'
subject="You have been Shortlisted"
body='''
Hi, congratulations your resume has been shortlisted for xyz role
'''
em=EmailMessage()
em['From']=email_sender
em['To']=email_recevier
em['Subject']=subject
em.set_content(body)
context=ssl.create_default_context()
with smtplib.SMTP_SSL('smtp.gmail.com',465,context=context) as smtp:
    smtp.login(email_sender,email_pass)
    smtp.sendmail(email_sender,email_recevier,em.as_string())