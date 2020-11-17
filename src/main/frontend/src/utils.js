export const averageRating = (reviews) => {
  if (reviews.length === 0) return undefined

  return (
    reviews.reduce((a, { rating }) => a + rating, 0) / reviews.length
  ).toFixed(1)
}
