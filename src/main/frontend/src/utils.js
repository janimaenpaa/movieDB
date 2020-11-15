export const averageRating = (reviews) => {
  if (reviews.length === 0) return undefined

  return reviews.reduce((a, b) => (a.rating + b.rating) / reviews.length).toFixed(1)
}
