//* Check spec characters and remove its
export function sanitize(string) {
  let value = string.replace(/[.*+?^${}<>`()[]|[\]\\]/g, ' ');

  return value.trim();
}

//*  Make first letter big
export function capitalize(string) {
  let value = string.charAt(0).toUpperCase() + string.slice(1);

  return value.trim();
}
