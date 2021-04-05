
|Service                        |URL                                                                                    |
|-------------------------------|---------------------------------------------------------------------------------------|
|Naming Server                  |http://localhost:8761/                                                                 |
|H2 Console                     |http://localhost:8000/h2-console                                                       |
|Currency Exchange              |http://localhost:8000/currency-exchange/v1/mapping/USD/INR                             |
|Currnecy Conversion            |http://localhost:8100/currency-conversion/v1/mapping/USD/INR/1.5                       |
|Currency API Gateway           |currency exchange: http://localhost:8765/currency-exchange/v1/mapping/USD/INR          |
|                               |currency conversion: http://localhost:8765/currency-conversion/v1/mapping/USD/INR/1.5  |                                                          

**Currency Conversion**

curl --location --request POST 'localhost:8100/currency-conversion/authenticate' \
--header 'Content-Type: application/json' \
--data-raw '{
    "name": "bhanu",
    "password": "password"
}'

curl --location --request GET 'localhost:8765/currency-conversion/v1/mapping/USD/INR/1.5' \
--header 'Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJiaGFudSIsImV4cCI6MTYxNzY1NTc1MSwiaWF0IjoxNjE3NjM3NzUxfQ.nVSbKdx4g5fYetYSBIxNx5NF7SMQQveSVQKwBpIgwDmQVG0ic2s3satemvKvocGkEknAKGN1-rbqqlv03o8pcw'
