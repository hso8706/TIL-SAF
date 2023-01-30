import math

class Car_sharing_service:
    rental_fee_per_unit = 1200 # 10분 단위
    insurance_fee_per_unit = 525 # 30분 단위
    driven_fee_default_per_km = 170
    driven_fee_over_per_km = int(170 * 0.5)

    def fee(self, rental_min, driven_km):
        rental_fee = math.ceil(rental_min / 10) * self.rental_fee_per_unit
        insurance_fee = math.ceil(rental_min / 30) * self.insurance_fee_per_unit
        if driven_km > 100:
            driven_fee = self.driven_fee_default_per_km * 100 + self.driven_fee_over_per_km * (driven_km - 100)
        else : 
            driven_fee = self.driven_fee_default_per_km * driven_km

        return rental_fee + insurance_fee + driven_fee

service = Car_sharing_service()
print(service.fee(600, 50))
print(service.fee(600, 110))
print(service.fee(45, 110))


    

# fee(600, 50) => 91000
# fee(600, 110) => 10