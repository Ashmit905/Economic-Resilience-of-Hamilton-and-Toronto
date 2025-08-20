# Use an official Python image
FROM python:3.11-slim

# Install cron
RUN apt-get update && apt-get install -y cron

# Create the working directory
WORKDIR /usr/app

# Copy requirements and install dependencies
COPY requirements.txt .
RUN pip install --no-cache-dir -r requirements.txt

COPY HousingIngester.py .
COPY TestHousingIngesterIntegration.py .

# Copy the cron job definition into /etc/cron.d/
COPY ingester-cron /etc/cron.d/ingester-cron
RUN chmod 0644 /etc/cron.d/ingester-cron

# By default, run cron in the foreground (so Docker doesn't exit immediately)
CMD ["cron", "-f"]
