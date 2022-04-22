package ru.netology

const val DISCOUNT = 100 // Скидка для тех, у кого предыдущая сумма покупок более 1000 рублей
const val DISCOUNT_MAX_PERCENT = 5 // Скидка 5% для тех, у кого предыдущая сумма покупок более 10000 рублей
const val DISCOUNT_MIN_PERCENT = 1 // Дополнительная скидка 1% для постоянных покупателей



fun main() {
    println("На какую сумму ваша текущая покупка?")
    val Price = readLine()!!.toInt()
    println("На какую сумму вы ранее приобрели товары в нашем магазине?")
    val totalPrice = readLine()!!.toInt()
    println("Это постоянный покупатель? (Да = 1 /Нет = 0)")
    //val regularCustomerInt = readLine()!!.toInt()
    val regularCustomer: Boolean = if (readLine()!!.toInt() == 1) true else false

    var FinalPrice:Double
    var finallyDiscount = ""
    if ((totalPrice > 1000) && (totalPrice < 10_000)) {
        finallyDiscount = (DISCOUNT.toString() + " рублей")
        FinalPrice = (Price - DISCOUNT).toDouble()
    } else if (totalPrice > 10_000) {
        finallyDiscount = (DISCOUNT_MAX_PERCENT.toString() + "%")
        FinalPrice = Price * ((100 - DISCOUNT_MAX_PERCENT)/100.toDouble())
    }else {
        finallyDiscount = 0.toString() + "%"
        FinalPrice = Price.toDouble()
    }

    if (regularCustomer) {
        finallyDiscount += ", а также -$DISCOUNT_MIN_PERCENT% от суммы покупки "
        FinalPrice *= ((100 - DISCOUNT_MIN_PERCENT) / 100.toDouble())
    }

    println("Итоговая сумма покупки составит: $FinalPrice Cкидка: $finallyDiscount")


}


