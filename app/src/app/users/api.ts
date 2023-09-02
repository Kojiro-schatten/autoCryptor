type UserList = {
  users: {
    id: number,
    name: string,
    createdAt: string,
    updatedAt: string
  }[]
}

export async function getUserList(): Promise<UserList> {
  const res = await fetch(`http://localhost:8080/users`)
  if (!res.ok) {
    throw new Error('Failed to fetch data')
  }
  return res.json();
}

export async function deleteUserList(id: number): Promise<string> {
  const url = `http://localhost:8080/users/${id}`
  console.log("url", url)
  const response = await fetch(url, {
    method: 'DELETE',
    mode: "cors",
    cache: "no-cache",
    headers: {
      "Content-Type":  "application/json"
    },
  });
  console.log(response)
  return response.text()
}

