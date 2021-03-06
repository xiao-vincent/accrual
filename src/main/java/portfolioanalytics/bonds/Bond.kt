package portfolioanalytics.bonds

import java.time.LocalDate
import java.time.temporal.ChronoUnit.DAYS

/**
 * A tradedBond represents a bond that's been purchased by an investor.
 * @author Vincent Xiao
 */
class TradedBond(
	 val cusip: String,
	 val evaluationDate: LocalDate,
	 val tradeDate: LocalDate?,
	 val settleDate: LocalDate?,
	 val originalCost: Double,
	 val amortizedCost: Double,
	 val marketValue: Double,
	 val accruedInterest: Double,
	 val yieldAtCost: Double,
	 securityType: SecurityType,
	 description: String?,
	 maturityDate: LocalDate,
	 par: Double,
	 coupon: Double,
	 spRating: SpRating?,
	 moodysRating: MoodysRating?
) : Bond(
	 securityType = securityType,
	 description = description,
	 maturityDate = maturityDate,
	 par = par,
	 coupon = coupon,
	 spRating = spRating,
	 moodysRating = moodysRating
) {
	val daysToMaturity: Long = DAYS.between(evaluationDate, maturityDate)
	val maturityRange: MaturityRange = MaturityRange.getRange(daysToMaturity.toInt())


	override fun toString(): String {
		return "TradedBond(cusip='$cusip', evaluationDate=$evaluationDate, tradeDate=$tradeDate, settleDate=$settleDate, originalCost=$originalCost, amortizedCost=$amortizedCost, marketValue=$marketValue, accruedInterest=$accruedInterest, yieldAtCost=$yieldAtCost, daysToMaturity=$daysToMaturity, maturityRange=$maturityRange)"
	}

	override fun equals(other: Any?): Boolean {
		if (this === other) return true
		if (javaClass != other?.javaClass) return false

		other as TradedBond

		if (cusip != other.cusip) return false
		if (evaluationDate != other.evaluationDate) return false
		if (tradeDate != other.tradeDate) return false
		if (settleDate != other.settleDate) return false
		if (originalCost != other.originalCost) return false
		if (amortizedCost != other.amortizedCost) return false
		if (marketValue != other.marketValue) return false
		if (accruedInterest != other.accruedInterest) return false
		if (yieldAtCost != other.yieldAtCost) return false
		if (daysToMaturity != other.daysToMaturity) return false
		if (maturityRange != other.maturityRange) return false

		return true
	}

	override fun hashCode(): Int {
		var result = cusip.hashCode()
		result = 31 * result + evaluationDate.hashCode()
		result = 31 * result + (tradeDate?.hashCode() ?: 0)
		result = 31 * result + (settleDate?.hashCode() ?: 0)
		result = 31 * result + originalCost.hashCode()
		result = 31 * result + amortizedCost.hashCode()
		result = 31 * result + marketValue.hashCode()
		result = 31 * result + accruedInterest.hashCode()
		result = 31 * result + yieldAtCost.hashCode()
		result = 31 * result + daysToMaturity.hashCode()
		result = 31 * result + maturityRange.hashCode()
		return result
	}
}

/**
 * A bond is a fixed-income security that represents a loan made by an investor to a borrower.
 * @author Vincent Xiao
 */
open class Bond(
	 val securityType: SecurityType,
	 val description: String?,
	 val maturityDate: LocalDate,
	 val par: Double,
	 val coupon: Double,
	 val spRating: SpRating?,
	 val moodysRating: MoodysRating?
) {
	override fun toString(): String {
		return "Bond(securityType=$securityType, description='$description', maturityDate=$maturityDate, par=$par, coupon=$coupon, spRating=$spRating, moodysRating=$moodysRating)"
	}
}